/*******************************************************************************
 * Copyright (c) 2017 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package de.dentrassi.flow.internal;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.ComponentContext.SharedResource;
import de.dentrassi.flow.ComponentInstance;
import de.dentrassi.flow.Connection;
import de.dentrassi.flow.FlowContext;
import de.dentrassi.flow.Port;
import de.dentrassi.flow.event.FlowEvent;
import de.dentrassi.flow.event.FlowListener;
import de.dentrassi.flow.event.ListenerHandle;
import de.dentrassi.flow.spi.type.ComponentFactory;

public class FlowRunner implements FlowContext {

    private static final Logger logger = LoggerFactory.getLogger(FlowRunner.class);

    private static final AtomicLong EVENT_THREAD_COUNTER = new AtomicLong();

    private final Map<String, ComponentShell> components = new HashMap<>();
    private final Map<String, FlowDataConnection> dataConnections = new HashMap<>();
    private final Map<String, FlowTriggerConnection> triggerConnections = new HashMap<>();

    private final List<ListenerEntry> listeners = new ArrayList<>();

    private final FlowExecutor executor;

    private final ComponentFactory componentFactory;

    private boolean running;

    private final FlowRunnerComponent contextComponent = new FlowRunnerComponent(this);
    private final ExecutorService eventExecutor;

    private static class ComponentInstanceImpl implements ComponentInstance {

        private final String type;
        private final String id;

        public ComponentInstanceImpl(final String type, final String id) {
            this.type = type;
            this.id = id;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public String getType() {
            return this.type;
        }

        @Override
        public String toString() {
            return String.format("%s[%s]", this.type, this.id);
        }

    }

    private static class ConnectionImpl implements Connection {

        private final String id;

        public ConnectionImpl(final String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return this.id;
        }

    }

    public FlowRunner(final FlowExecutor executor, final ComponentFactory componentFactory) {
        this.executor = executor;
        this.componentFactory = componentFactory;

        this.components.put("flow",
                new InstanceComponentShell(new ComponentInstanceImpl("flow", "flow"), this.contextComponent));

        this.eventExecutor = Executors
                .newSingleThreadExecutor(r -> {
                    return new Thread(r, "flow-events-" + EVENT_THREAD_COUNTER.getAndIncrement());
                });
    }

    public void close() {
        this.eventExecutor.shutdown();
    }

    @Override
    public String getId() {
        return "flow";
    }

    @Override
    public String getType() {
        return "flow";
    }

    @Override
    public ComponentInstance createComponent(String id, final String componentType, Map<String, String> initializers) {

        checkContext();

        Objects.requireNonNull(componentType);

        if (initializers == null) {
            initializers = Collections.emptyMap();
        }

        if (id == null || id.isEmpty()) {
            id = UUID.randomUUID().toString();
        } else {
            if (this.components.containsKey(id)) {
                throw new IllegalStateException(String.format("Component with id '%s' already exists", id));
            }
        }

        final ComponentInstanceImpl component = new ComponentInstanceImpl(componentType, id);

        final ComponentShell componentShell = createComponentShell(component, initializers);

        this.components.put(id, componentShell);

        if (isRunning()) {
            componentShell.start(this, createComponentContext(component));
        }

        emitFlowEvent(FlowEvent.addComponent(id, componentType));

        return component;
    }

    private <T> T workWithPorts(final Port out, final Port in,
            final BiFunction<ComponentShell, ComponentShell, T> function) {

        checkContext();

        validatePort(out);
        validatePort(in);

        final ComponentShell outShell = lookup(out.getComponent());
        final ComponentShell inShell = lookup(in.getComponent());

        if (outShell == null) {
            throw new IllegalArgumentException("Unable to find component: " + out.getComponent());
        }
        if (inShell == null) {
            throw new IllegalArgumentException("Unable to find component: " + in.getComponent());
        }

        return function.apply(outShell, inShell);
    }

    @Override
    public Connection connectTrigger(final Port out, final Port in) {
        return workWithPorts(out, in, (outShell, inShell) -> {

            final String id = UUID.randomUUID().toString();

            final FlowTriggerConnection connection = new FlowTriggerConnection(out, in, this.executor);
            outShell.addTriggerOutConnection(out.getPortName(), connection.out());
            inShell.addTriggerInConnection(in.getPortName(), connection.in());

            this.triggerConnections.put(id, connection);

            return new ConnectionImpl(id);
        });
    }

    @Override
    public Connection connectData(final Port out, final Port in, final Class<?> requiredType) {

        return workWithPorts(out, in, (outShell, inShell) -> {

            final String id = UUID.randomUUID().toString();

            final FlowDataConnection connection = new FlowDataConnection(out, in,
                    requiredType != null ? requiredType : Object.class);

            outShell.addDataOutConnection(out.getPortName(), connection.out());
            inShell.addDataInConnection(in.getPortName(), connection.in());

            this.dataConnections.put(id, connection);

            return new ConnectionImpl(id);
        });
    }

    private static void validatePort(final Port port) {
        requireNonNull(port);
        requireNonNull(port.getComponent());
        requireNonNull(port.getPortName());
    }

    protected ComponentShell lookup(final ComponentInstance componentInstance) {
        return this.components.get(componentInstance.getId());
    }

    protected ComponentShell createComponentShell(final ComponentInstance component,
            final Map<String, String> initializers) {
        final ComponentShell shell = new FactoryComponentShell(this.componentFactory, component, initializers);

        return shell;
    }

    protected void checkContext() {
        if (!this.executor.isExecutorThread()) {
            throw new IllegalStateException("Illegal access from outside context");
        }
    }

    public void start() {
        checkContext();

        this.running = true;

        // start all shells

        for (final Map.Entry<String, ComponentShell> entry : this.components.entrySet()) {
            entry.getValue().start(this, createComponentContext(entry.getValue().getComponent()));
        }

        // signal start

        this.contextComponent.triggerStarted();
    }

    public void stop() {
        checkContext();

        this.running = false;

        // stop all shells

        for (final ComponentShell shell : this.components.values()) {
            shell.stop();
        }

    }

    public boolean isRunning() {
        return this.running;
    }

    private final Map<String, SharedResourceImpl<?>> sharedResources = new HashMap<>();

    private final class SharedResourceImpl<T> implements SharedResource<T> {

        private final AtomicLong counter;
        private final T value;
        private final Runnable closeHandler;

        private boolean closed;

        public SharedResourceImpl(final AtomicLong counter, final T value, final Runnable closeHandler) {
            this.counter = counter;
            this.value = value;
            this.closeHandler = closeHandler;
        }

        @Override
        public T get() {
            return this.value;
        }

        @Override
        public void close() {
            checkContext();

            if (this.closed) {
                return;
            }

            this.closed = true;

            if (this.counter.decrementAndGet() == 0) {
                this.closeHandler.run();
            }
        }

        public <U> SharedResource<U> increment(final Class<U> clazz) {
            final SharedResource<U> result = new SharedResourceImpl<>(this.counter, clazz.cast(this.value),
                    this.closeHandler);
            this.counter.incrementAndGet();
            return result;
        }

    }

    <T> SharedResource<T> createSharedResource(final String namespace, final String key, final Class<T> clazz,
            final Supplier<T> supplier, final Consumer<T> closeHandler) {
        checkContext();

        final String fullKey = String.format("%s.%s", namespace, key);

        SharedResourceImpl<?> result = this.sharedResources.get(fullKey);
        if (result == null) {
            final T value = supplier.get();
            result = new SharedResourceImpl<>(new AtomicLong(0L), value, () -> closeHandler.accept(value));
            this.sharedResources.put(fullKey, result);
        }

        return result.increment(clazz);
    }

    void run(final Runnable runnable) {
        this.executor.execute(runnable);
    }

    private final class ListenerEntry {

        private final boolean initialize;
        private final CompletableFuture<Void> future;
        private final FlowListener listener;

        private ListenerEntry(final boolean initialize, final CompletableFuture<Void> future,
                final FlowListener listener) {
            this.initialize = initialize;
            this.future = future;
            this.listener = listener;
        }

        public void event(final FlowEvent event) {
            this.listener.flowEvent(event);
        }

        public FlowListener getListener() {
            return this.listener;
        }

        public CompletableFuture<Void> getFuture() {
            return this.future;
        }

        public boolean isInitialize() {
            return this.initialize;
        }
    }

    public ListenerHandle registerListener(final boolean initialize, final FlowListener listener) {

        final CompletableFuture<Void> future = new CompletableFuture<>();

        final ListenerEntry entry = new ListenerEntry(initialize, future, listener);

        this.executor.execute(() -> initializeListener(entry));

        return new ListenerHandle() {

            @Override
            public void close() {
                FlowRunner.this.executor.execute(() -> internalCloseListener(entry));
            }

            @Override
            public CompletableFuture<Void> initialized() {
                return future;
            }
        };
    }

    private void initializeListener(final ListenerEntry listener) {
        checkContext();

        // record listener

        this.listeners.add(listener);

        if (!listener.isInitialize()) {

            this.eventExecutor.execute(() -> listener.getFuture().complete(null));

            // no need to initialize
            return;
        }

        // send out current state

        for (final Map.Entry<String, ComponentShell> entry : this.components.entrySet()) {

            final String id = entry.getKey();
            final ComponentShell shell = entry.getValue();

            final FlowEvent event = FlowEvent.addComponent(id, shell.getComponent().getType());
            this.eventExecutor.execute(() -> listener.getListener().flowEvent(event));

            final List<FlowEvent> events = FlowEvent.addPorts(entry.getValue().getComponent(),
                    shell.getReportedPorts());
            this.eventExecutor.execute(() -> events.forEach(e -> listener.getListener().flowEvent(e)));
        }

        for (final Map.Entry<String, FlowDataConnection> entry : this.dataConnections.entrySet()) {

            final String id = entry.getKey();
            final FlowDataConnection connection = entry.getValue();

            final FlowEvent event = FlowEvent.addDataConnection(id, connection.getOutPort(), connection.getInPort());

            this.eventExecutor.execute(() -> listener.getListener().flowEvent(event));

        }

        for (final Map.Entry<String, FlowTriggerConnection> entry : this.triggerConnections.entrySet()) {

            final String id = entry.getKey();
            final FlowTriggerConnection connection = entry.getValue();

            final FlowEvent event = FlowEvent.addTriggerConnection(id, connection.getOutPort(), connection.getInPort());

            this.eventExecutor.execute(() -> listener.getListener().flowEvent(event));

        }

        // notify complete from the same thread

        this.eventExecutor.execute(() -> listener.getFuture().complete(null));
    }

    void emitFlowEvent(final FlowEvent event) {
        checkContext();

        logger.debug("emitFlowEvent - {}", event);

        for (final ListenerEntry entry : this.listeners) {
            this.eventExecutor.execute(() -> entry.event(event));
        }
    }

    protected void internalCloseListener(final ListenerEntry entry) {
        this.listeners.remove(entry);
    }

    protected ComponentContext createComponentContext(final ComponentInstance component) {
        return new ComponentContextImpl(this);
    }
}

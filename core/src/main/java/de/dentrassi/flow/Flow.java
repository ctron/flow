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
package de.dentrassi.flow;

import java.util.Objects;
import java.util.function.Consumer;

import de.dentrassi.flow.event.FlowListener;
import de.dentrassi.flow.event.ListenerHandle;
import de.dentrassi.flow.internal.FlowExecutorImpl;
import de.dentrassi.flow.internal.FlowRunner;
import de.dentrassi.flow.spi.type.ComponentFactory;

/**
 * A running flow instance.
 */
public class Flow implements AutoCloseable {

    private final FlowRunner runner;
    private final FlowExecutorImpl executor;

    public Flow(final ComponentFactory componentFactory) {
        this.executor = new FlowExecutorImpl();

        this.runner = new FlowRunner(this.executor, componentFactory);

        this.executor.start();
    }

    /**
     * Start processing.
     */
    public void start() {
        this.executor.execute(this.runner::start);
    }

    /**
     * Stop processing.
     */
    public void stop() {
        this.executor.execute(this.runner::stop);
    }

    /**
     * Make modifications to the flow.
     * 
     * The consumer will be called from the flow context thread. The method will
     * return <em>before</em> this call is processed. The reference to the
     * {@link FlowContext} must not be stored.
     * 
     * @param consumer
     *            The consumer which is allowed to modify the flow instance.
     */
    public void modify(final Consumer<FlowContext> consumer) {
        Objects.requireNonNull(consumer);

        this.executor.execute(() -> {
            consumer.accept(this.runner);
        });
    }

    @Override
    public void close() throws Exception {
        this.runner.close();
        this.executor.stop();
    }

    public ListenerHandle registerListener(final boolean initialize, final FlowListener listener) {
        return this.runner.registerListener(initialize, listener);
    }
}

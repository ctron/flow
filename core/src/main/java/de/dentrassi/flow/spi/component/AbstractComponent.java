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
package de.dentrassi.flow.spi.component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.Component;
import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.PortType;
import de.dentrassi.flow.spi.DataPlugIn;
import de.dentrassi.flow.spi.DataPlugOut;
import de.dentrassi.flow.spi.TriggerPlugIn;
import de.dentrassi.flow.spi.TriggerPlugOut;

public abstract class AbstractComponent implements Component {

    private static final Logger logger = LoggerFactory.getLogger(AbstractComponent.class);

    private final Map<String, TriggerPortOut> outTriggers = new HashMap<>();
    private final Map<String, TriggerPortIn> inTriggers = new HashMap<>();
    private final Map<String, DataPortOut> outData = new HashMap<>();
    private final Map<String, DataPortIn> inData = new HashMap<>();

    private Map<String, String> initializers;
    private ComponentContext context;

    private EventContext event;

    @Override
    public void start(final Map<String, String> initializers, final ComponentContext context,
            final EventContext event) {
        this.initializers = initializers;
        this.context = context;
        this.event = event;

        this.outTriggers.keySet().forEach(name -> emitAddPort(name, PortType.TRIGGER_OUT));
        this.inTriggers.keySet().forEach(name -> emitAddPort(name, PortType.TRIGGER_IN));
        this.outData.keySet().forEach(name -> emitAddPort(name, PortType.DATA_OUT));
        this.inData.keySet().forEach(name -> emitAddPort(name, PortType.DATA_IN));
    }

    @Override
    public void stop() {
    }

    protected void runOnContext(final Runnable runnable) {
        this.context.run(runnable);
    }

    protected String getInitializer(final String key) {
        return this.initializers.get(key);
    }

    protected String getInitializer(final String key, final String defaultValue) {
        return this.initializers.getOrDefault(key, defaultValue);
    }

    protected Long getInitializerLong(final String key, final Long defaultValue) {
        final String value = this.initializers.get(key);

        if (value != null) {
            try {
                return Long.parseLong(value);
            } catch (final NumberFormatException e) {
            }
        }

        return defaultValue;
    }

    protected Double getInitializerDouble(final String key, final Double defaultValue) {
        final String value = this.initializers.get(key);

        if (value != null) {
            try {
                return Double.parseDouble(value);
            } catch (final NumberFormatException e) {
            }
        }

        return defaultValue;
    }

    private void emitAddPort(final String name, final PortType type) {
        if (this.event != null) {
            this.event.addedPort(name, type);
        }
    }

    protected TriggerPortOut registerTriggerOut(final String portName) {
        final TriggerPortOut result = new TriggerPortOut();
        this.outTriggers.put(portName, result);

        emitAddPort(portName, PortType.TRIGGER_OUT);

        return result;
    }

    protected void registerTriggerIn(final String portName, final Runnable runnable) {

        this.inTriggers.put(portName, new TriggerPortIn(runnable));

        emitAddPort(portName, PortType.TRIGGER_IN);
    }

    protected void triggerOut(final String portName) {
        final TriggerPortOut port = this.outTriggers.get(portName);
        port.execute();
    }

    protected void updateAllData() {
        for (final Map.Entry<String, DataPortIn> in : this.inData.entrySet()) {
            try {
                in.getValue().update();
            } catch (final Exception e) {
                logger.warn("Failed to update port: {}", in.getKey(), e);
                throw e;
            }
        }
    }

    protected DataPortOut getDataPortOut(final String portName) {
        return this.outData.get(portName);
    }

    protected DataPortIn getDataPortIn(final String portName) {
        return this.inData.get(portName);
    }

    protected TriggerPortOut getTriggerPortOut(final String portName) {
        return this.outTriggers.get(portName);
    }

    protected TriggerPortIn getTriggerPortIn(final String portName) {
        return this.inTriggers.get(portName);
    }

    protected void registerDataOut(final String portName, final Supplier<?> supplier) {
        this.outData.put(portName, new DataPortOut(DataPortOut.singleType(supplier, () -> null)));
        emitAddPort(portName, PortType.DATA_OUT);
    }

    protected void registerDataOut(final String portName, final Function<ValueRequest, ValueResult> supplier) {
        this.outData.put(portName, new DataPortOut(supplier));
        emitAddPort(portName, PortType.DATA_OUT);
    }

    protected <T extends DataPortIn> T registerDataIn(final String portName, final T port) {
        this.inData.put(portName, port);
        emitAddPort(portName, PortType.DATA_IN);
        return port;
    }

    protected void registerDataIn(final String portName, final Supplier<Object> initializer,
            final Consumer<ValueResult> consumer) {
        registerDataIn(portName, new BoundDataPortIn(initializer, consumer));
    }

    protected <T> void registerDataIn(final String portName, final Class<T> clazz, final Supplier<T> initializer,
            final Supplier<T> incompatibleValue, final Consumer<T> consumer) {
        registerDataIn(portName, new BoundDataPortIn(clazz, initializer, incompatibleValue, consumer));
    }

    protected <T> void registerDataIn(final String portName, final Class<T> clazz, final Supplier<T> initializer,
            final Consumer<T> consumer) {
        registerDataIn(portName, new BoundDataPortIn(clazz, initializer, () -> null, consumer));
    }

    private <T> T getPort(final String portType, final String portName, final Map<String, T> ports) {
        final T port = ports.get(portName);
        if (port == null) {
            throw new IllegalArgumentException(
                    String.format("%s '%s' on component %s not found", portType, portName, this));
        }
        return port;
    }

    @Override
    public void connectTriggerOut(final String portName, final TriggerPlugOut plug) {
        getPort("Trigger Out Port", portName, this.outTriggers).add(plug);
    }

    @Override
    public void connectTriggerIn(final String portName, final TriggerPlugIn plug) {
        getPort("Trigger In Port", portName, this.inTriggers).add(plug);
    }

    @Override
    public void connectDataOut(final String portName, final DataPlugOut plug) {
        plug.setSupplier(getPort("Data Out Port", portName, this.outData));
    }

    @Override
    public void connectDataIn(final String portName, final DataPlugIn plug) {
        getPort("Data In Port", portName, this.inData).add(plug);
    }

}
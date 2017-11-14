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

import de.dentrassi.flow.Component;
import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.spi.DataPlugIn;
import de.dentrassi.flow.spi.DataPlugOut;
import de.dentrassi.flow.spi.TriggerPlugIn;
import de.dentrassi.flow.spi.TriggerPlugOut;

public abstract class AbstractComponent implements Component {

    private final Map<String, TriggerPortOut> outTriggers = new HashMap<>();
    private final Map<String, TriggerPortIn> inTriggers = new HashMap<>();

    private final Map<String, DataPortOut> outData = new HashMap<>();
    private final Map<String, DataPortIn> inData = new HashMap<>();
    private Map<String, String> initializers;
    private ComponentContext context;

    @Override
    public void start(final Map<String, String> initializers, final ComponentContext context) {
        this.initializers = initializers;
        this.context = context;
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

    protected TriggerPortOut registerTriggerOut(final String portName) {
        final TriggerPortOut result = new TriggerPortOut();
        this.outTriggers.put(portName, result);
        return result;
    }

    protected void registerTriggerIn(final String portName, final Runnable runnable) {
        this.inTriggers.put(portName, new TriggerPortIn(runnable));
    }

    protected void triggerOut(final String portName) {
        final TriggerPortOut port = this.outTriggers.get(portName);
        port.execute();
    }

    protected void updateAllData() {
        for (final DataPortIn in : this.inData.values()) {
            in.update();
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
    }

    protected void registerDataOut(final String portName, final Function<ValueRequest, ValueResult> supplier) {
        this.outData.put(portName, new DataPortOut(supplier));
    }

    protected <T extends DataPortIn> T registerDataIn(final String portName, final T port) {
        this.inData.put(portName, port);
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
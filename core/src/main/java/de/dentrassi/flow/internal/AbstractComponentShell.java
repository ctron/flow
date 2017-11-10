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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.Component;
import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.FlowContext;
import de.dentrassi.flow.spi.DataPlugIn;
import de.dentrassi.flow.spi.DataPlugOut;
import de.dentrassi.flow.spi.TriggerPlugIn;
import de.dentrassi.flow.spi.TriggerPlugOut;

public abstract class AbstractComponentShell implements ComponentShell {

    private static final Logger logger = LoggerFactory.getLogger(AbstractComponentShell.class);

    private Component component;
    private final Map<String, String> initializers;

    private FlowContext flowContext;
    private ComponentContext componentContext;

    private static class Entry<T> {
        final String portName;
        final T plug;

        public Entry(final String portName, final T plug) {
            this.portName = portName;
            this.plug = plug;
        }
    }

    private final List<Entry<DataPlugIn>> dataIn = new LinkedList<>();
    private final List<Entry<DataPlugOut>> dataOut = new LinkedList<>();
    private final List<Entry<TriggerPlugIn>> triggerIn = new LinkedList<>();
    private final List<Entry<TriggerPlugOut>> triggerOut = new LinkedList<>();

    public AbstractComponentShell(final Map<String, String> initializers) {
        this.initializers = initializers;
    }

    @Override
    public void start(final FlowContext flowContext, final ComponentContext componentContext) {
        this.flowContext = flowContext;
        this.componentContext = componentContext;
    }

    @Override
    public void stop() {
        this.flowContext = null;

        if (this.component != null) {
            this.component.stop();
            this.component = null;
        }
    }

    protected void setInstance(final Component component) {
        if (!isStarted()) {
            throw new IllegalStateException("Component may only be set when started");
        }

        this.component = component;
        initializeAndStart();
    }

    private boolean isStarted() {
        return this.flowContext != null;
    }

    private void initializeAndStart() {

        for (final Entry<DataPlugIn> entry : this.dataIn) {
            this.component.connectDataIn(entry.portName, entry.plug);
        }
        for (final Entry<DataPlugOut> entry : this.dataOut) {
            this.component.connectDataOut(entry.portName, entry.plug);
        }

        for (final Entry<TriggerPlugIn> entry : this.triggerIn) {
            this.component.connectTriggerIn(entry.portName, entry.plug);
        }
        for (final Entry<TriggerPlugOut> entry : this.triggerOut) {
            this.component.connectTriggerOut(entry.portName, entry.plug);
        }

        this.component.start(this.initializers, this.componentContext);
    }

    protected void setErrorInstance(final Throwable e) {
        logger.info("Failed creating instance", e);
        // FIXME: set some error instance component
    }

    @Override
    public void addDataInConnection(final String portName, final DataPlugIn in) {
        this.dataIn.add(new Entry<>(portName, in));
        if (this.component != null) {
            this.component.connectDataIn(portName, in);
        }
    }

    @Override
    public void addDataOutConnection(final String portName, final DataPlugOut out) {
        this.dataOut.add(new Entry<>(portName, out));
        if (this.component != null) {
            this.component.connectDataOut(portName, out);
        }
    }

    @Override
    public void addTriggerInConnection(final String portName, final TriggerPlugIn in) {
        this.triggerIn.add(new Entry<>(portName, in));
        if (this.component != null) {
            this.component.connectTriggerIn(portName, in);
        }
    }

    @Override
    public void addTriggerOutConnection(final String portName, final TriggerPlugOut out) {
        this.triggerOut.add(new Entry<>(portName, out));
        if (this.component != null) {
            this.component.connectTriggerOut(portName, out);
        }
    }

}

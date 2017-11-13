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

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.spi.TriggerPlugIn;
import de.dentrassi.flow.spi.TriggerPlugOut;

public class FlowTriggerConnection {

    private static final Logger logger = LoggerFactory.getLogger(FlowTriggerConnection.class);

    private final TriggerPlugIn in = new TriggerPlugIn() {

        @Override
        public void subscribe(final Runnable runnable) {
            FlowTriggerConnection.this.listeners.add(runnable);
        }

        @Override
        public void unsubscribe(final Runnable runnable) {
            FlowTriggerConnection.this.listeners.remove(runnable);
        }
    };

    private final TriggerPlugOut out = new TriggerPlugOut() {

        @Override
        public void execute() {
            process();
        }
    };

    private final Set<Runnable> listeners = new HashSet<>();

    private final FlowExecutor executor;

    public FlowTriggerConnection(final FlowExecutor executor) {
        this.executor = executor;
    }

    protected void process() {
        this.executor.execute(() -> {
            for (final Runnable runnable : this.listeners) {
                try {
                    runnable.run();
                } catch (final Exception e) {
                    logger.info("Failed to run trigger connection", e);
                    // FIXME: handle error
                }
            }
        });
    }

    public TriggerPlugIn in() {
        return this.in;
    }

    public TriggerPlugOut out() {
        return this.out;
    }

}

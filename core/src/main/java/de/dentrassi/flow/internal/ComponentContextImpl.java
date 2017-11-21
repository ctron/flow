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

import java.util.function.Consumer;
import java.util.function.Supplier;

import de.dentrassi.flow.ComponentContext;

public class ComponentContextImpl implements ComponentContext {

    private final FlowRunner flowRunner;

    public ComponentContextImpl(final FlowRunner flowRunner) {
        this.flowRunner = flowRunner;
    }

    @Override
    public <T> SharedResource<T> createSharedResource(final String namespace, final String key, final Class<T> clazz,
            final Supplier<T> supplier, final Consumer<T> closeHandler) {
        return this.flowRunner.createSharedResource(namespace, key, clazz, supplier, closeHandler);
    }

    @Override
    public void run(final Runnable runnable) {
        this.flowRunner.run(runnable);
    }

}

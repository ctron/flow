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

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ComponentContext {

    public interface SharedResource<T> extends AutoCloseable {

        public T get();

        @Override
        public void close();
    }

    public <T> SharedResource<T> createSharedResource(String namespace, String key, Class<T> clazz,
            Supplier<T> supplier, Consumer<T> closeHandler);

    public default <T> SharedResource<T> createSharedResource(final Class<?> namespace, final String key,
            final Class<T> clazz, final Supplier<T> supplier, final Consumer<T> closeHandler) {
        return createSharedResource(namespace.getName(), key, clazz, supplier, closeHandler);
    }

    /**
     * Schedule to run on the context thread.
     * 
     * @param runnable
     *            the runnable to run
     */
    public void run(Runnable runnable);
}

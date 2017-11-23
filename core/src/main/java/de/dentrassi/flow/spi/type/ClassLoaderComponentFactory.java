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
package de.dentrassi.flow.spi.type;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.spi.Component;
import de.dentrassi.flow.type.ComponentFactory;

public class ClassLoaderComponentFactory implements ComponentFactory {

    private static final Logger logger = LoggerFactory.getLogger(ClassLoaderComponentFactory.class);

    private final ClassLoader classLoader;

    private static final LookupHandle HANDLE = new LookupHandle() {

        @Override
        public void close() {
        }
    };

    public ClassLoaderComponentFactory(final ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public Component create(final String componentType) throws Exception {
        final Class<? extends Component> clazz = lookupClass(componentType);
        return clazz.newInstance();
    }

    @Override
    public LookupHandle lookup(final String componentType, final Consumer<ComponentTypeProvider> typeProvider) {
        logger.debug("Looking up component type: {}", componentType);
        try {
            final Class<? extends Component> clazz = lookupClass(componentType);
            logger.debug("Resolved to: {}", clazz);
            typeProvider.accept(new ClassTypeProvider(clazz));
        } catch (final Exception e) {
            logger.warn("Failed to load class", e);
        }
        return HANDLE;
    }

    protected Class<? extends Component> lookupClass(final String componentType) throws Exception {
        final Class<?> clazz = Class.forName(componentType, true, this.classLoader);
        if (Component.class.isAssignableFrom(clazz)) {
            return clazz.asSubclass(Component.class);
        } else {
            return null;
        }
    }

}

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
package de.dentrassi.flow.type;

import java.util.function.Consumer;

import de.dentrassi.flow.spi.Component;
import de.dentrassi.flow.spi.type.ComponentTypeProvider;

public interface ComponentFactory {

    public static interface LookupHandle extends AutoCloseable {
        @Override
        public void close();
    }

    public Component create(String type) throws Exception;

    public LookupHandle lookup(String componentType, Consumer<ComponentTypeProvider> typeProvider);
}

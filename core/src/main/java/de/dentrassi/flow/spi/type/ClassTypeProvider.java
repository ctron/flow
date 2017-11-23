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

import de.dentrassi.flow.spi.Component;

class ClassTypeProvider implements ComponentTypeProvider {

    private final Class<? extends Component> clazz;

    public ClassTypeProvider(final Class<? extends Component> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Component createType(final String componentType) throws Exception {
        return this.clazz.newInstance();
    }

}

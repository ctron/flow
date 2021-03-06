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
package de.dentrassi.flow.component;

import de.dentrassi.flow.spi.component.SimpleTransformationComponent;

public class Not extends SimpleTransformationComponent<Boolean, Boolean> {

    public Not() {
        super(Boolean.class, Boolean.class);
    }

    @Override
    public Boolean convertValue(final Boolean input) {
        return !input;
    }

}

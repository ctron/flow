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

public class StringToDouble extends SimpleTransformationComponent<String, Double> {

    public StringToDouble() {
        super(String.class, Double.class);
    }

    @Override
    public Double convertValue(final String input) {
        return Double.parseDouble(input);
    }

}

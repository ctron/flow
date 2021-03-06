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

public class StringToLong extends SimpleTransformationComponent<String, Long> {

    public StringToLong() {
        super(String.class, Long.class);
    }

    @Override
    public Long convertValue(final String input) {
        return Long.parseLong(input);
    }

}

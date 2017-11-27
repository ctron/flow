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
package de.dentrassi.flow.internal.type;

import de.dentrassi.flow.spi.type.TypeConverter;

public class DefaultToString implements TypeConverter {

    @Override
    public boolean supports(final Class<?> from, final Class<?> to) {
        return String.class.equals(to);
    }

    @Override
    public <T, R> R convert(final T value, final Class<R> clazz) {
        return clazz.cast(value.toString());
    }

}

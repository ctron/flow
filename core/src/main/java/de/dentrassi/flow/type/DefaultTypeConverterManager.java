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

import java.util.HashSet;
import java.util.Set;

import de.dentrassi.flow.internal.type.DefaultFromString;
import de.dentrassi.flow.internal.type.DefaultToString;
import de.dentrassi.flow.spi.type.TypeConverter;

public class DefaultTypeConverterManager implements TypeConverterManager {

    private final Set<TypeConverter> converters = new HashSet<>();

    public DefaultTypeConverterManager() {
        this.converters.add(new DefaultToString());
        this.converters.add(new DefaultFromString());
    }

    @Override
    public <T, R> R convert(final T value, final Class<R> to) {

        if (value == null) {
            return null;
        }

        final Class<?> from = value.getClass();

        if (to.isAssignableFrom(from)) {
            return to.cast(value);
        }

        for (final TypeConverter converter : this.converters) {
            if (converter.supports(from, to)) {
                return converter.convert(value, to);
            }
        }

        throw new ClassCastException("No converter found for " + value.getClass() + " to " + to);
    }

    @Override
    public void close() {
    }

}

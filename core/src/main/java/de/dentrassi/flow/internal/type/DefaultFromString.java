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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import de.dentrassi.flow.spi.type.TypeConverter;

public class DefaultFromString implements TypeConverter {

    private final Map<Class<?>, Function<String, ?>> converters = new HashMap<>();

    public DefaultFromString() {
        this.converters.put(Integer.class, Integer::valueOf);
        this.converters.put(Long.class, Long::valueOf);
        this.converters.put(Double.class, Double::valueOf);
        this.converters.put(Boolean.class, Boolean::valueOf);
        this.converters.put(Short.class, Short::valueOf);
        this.converters.put(Byte.class, Byte::valueOf);
    }

    @Override
    public boolean supports(final Class<?> from, final Class<?> to) {

        if (!String.class.equals(from)) {
            return false;
        }

        return this.converters.containsKey(to);
    }

    @Override
    public <T, R> R convert(final T value, final Class<R> clazz) {
        final Function<String, ?> cvt = this.converters.get(clazz);
        return clazz.cast(cvt.apply((String) value));
    }

}

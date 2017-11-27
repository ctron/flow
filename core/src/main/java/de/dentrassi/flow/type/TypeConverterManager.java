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

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.util.Optional;

public interface TypeConverterManager extends AutoCloseable {
    /**
     * Convert type
     * 
     * @param value
     *            the value to convert
     * @param to
     *            the target type
     * @return the result
     * @throws ClassCastException
     *             if the type cannot be converted
     */
    public <T, R> R convert(T value, Class<R> to);

    public default <T, R> Optional<R> convertOptionally(final T value, final Class<R> to) {
        try {
            return ofNullable(convert(value, to));
        } catch (final ClassCastException e) {
            return empty();
        }
    }

    @Override
    public void close();
}

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
package de.dentrassi.flow.spi.component;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

import java.util.List;

public final class ValueRequest {

    private final List<Class<?>> types;

    private ValueRequest(final Class<?> requiredType) {
        this.types = singletonList(requiredType);
    }

    public List<Class<?>> getTypes() {
        return this.types;
    }

    public static ValueRequest of(final Class<?> requiredType) {
        requireNonNull(requiredType);
        return new ValueRequest(requiredType);
    }

    /**
     * Check if a requests contains a request for this class
     * 
     * @param clazz
     *            the class to check
     * @return {@code true } if is does
     */
    public boolean requests(final Class<?> clazz) {
        for (final Class<?> requestClass : this.types) {
            if (requestClass.isAssignableFrom(clazz)) {
                return true;
            }
        }

        return false;
    }

}

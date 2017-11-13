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

import static java.util.Objects.requireNonNull;

import java.util.function.Function;
import java.util.function.Supplier;

public class DataPortOut {

    private final Function<ValueRequest, ValueResult> supplier;

    public DataPortOut(final Function<ValueRequest, ValueResult> supplier) {
        this.supplier = supplier;
    }

    public ValueResult get(final ValueRequest request) {
        return this.supplier.apply(request);
    }

    public static Function<ValueRequest, ValueResult> singleType(final Supplier<?> supplier,
            final Supplier<?> defaultValue) {

        requireNonNull(supplier);
        requireNonNull(defaultValue);

        return request -> {
            final Object value = supplier.get();
            if (value == null) {
                return null;
            }

            final Class<?> valueClass = value.getClass();
            for (final Class<?> type : request.getTypes()) {
                if (type.isAssignableFrom(valueClass)) {
                    return ValueResult.of(value);
                }
            }

            return ValueResult.of(defaultValue.get());
        };
    }
}

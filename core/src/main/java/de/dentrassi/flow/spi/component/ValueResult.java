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

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import java.util.List;

public final class ValueResult {

    private final static ValueResult NULL = new ValueResult(null, null);

    private final List<?> values;

    private final Throwable error;

    public ValueResult(final List<?> values, final Throwable error) {
        this.values = values;
        this.error = error;
    }

    public List<?> getValues() {
        return this.values;
    }

    public Throwable getError() {
        return this.error;
    }

    public boolean isError() {
        return this.error != null;
    }

    public boolean isNull() {
        return this.values == null;
    }

    @Override
    public String toString() {
        return String.format("[ValueResult: %s]", this.values);
    }

    public static ValueResult ofError(final Throwable e) {
        return new ValueResult(null, e);
    }

    public static ValueResult of() {
        return new ValueResult(null, null);
    }

    public static ValueResult of(final Object value) {
        if (value != null) {
            return new ValueResult(singletonList(value), null);
        } else {
            return NULL;
        }
    }

    public static ValueResult ofList(final List<?> values) {
        if (values != null) {
            return new ValueResult(values, null);
        } else {
            return NULL;
        }
    }

    public static ValueResult of(final Object... value) {
        // FIXME: do null check
        return new ValueResult(asList(value), null);
    }

    public <T> T getValueAs(final Class<T> type) throws Exception {
        if (this.values == null) {
            return null;
        }

        for (final Object v : this.values) {
            if (type.isAssignableFrom(v.getClass())) {
                return type.cast(v);
            }
        }

        throw new IllegalStateException("Unable to convert to: " + type);
    }

}

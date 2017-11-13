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

public abstract class SimpleTransformationComponent<T, R> extends TransformationComponent {

    private final Class<T> from;
    private final Class<R> to;

    public SimpleTransformationComponent(final Class<T> from, final Class<R> to) {
        requireNonNull(from);
        requireNonNull(to);

        this.from = from;
        this.to = to;
    }

    @Override
    public ValueResult convert(final ValueRequest request, final ValueResult input) throws Exception {

        if (input.isNull()) {
            return input;
        }

        if (!request.requests(this.to)) {
            return ValueResult
                    .ofError(new IllegalStateException("Component only supports converting to: " + this.to.getName()));
        }

        return ValueResult.of(convertValue(input.getValueAs(this.from)));
    }

    public abstract R convertValue(T input);

}

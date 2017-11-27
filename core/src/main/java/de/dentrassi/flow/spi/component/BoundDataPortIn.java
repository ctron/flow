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

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BoundDataPortIn extends AbstractSingleDataPortIn {

    private final ValueRequest request;
    private final Supplier<? extends Object> initializer;
    private final Consumer<ValueResult> consumer;

    private boolean initializerLoaded;
    private Object initializerValue;

    public BoundDataPortIn(final Supplier<Object> initializer, final Consumer<ValueResult> consumer) {
        this.request = ValueRequest.of(Object.class);
        this.initializer = initializer;
        this.consumer = consumer;
    }

    public <T> BoundDataPortIn(final Class<T> clazz, final Supplier<T> initializer, final Supplier<T> incompatibleValue,
            final Consumer<T> consumer) {

        this.request = ValueRequest.of(clazz);

        this.initializer = initializer;
        this.consumer = value -> {
            boolean called = false;

            final List<?> values = value.getValues();
            if (values != null) {
                for (final Object v : value.getValues()) {
                    if (clazz.isAssignableFrom(v.getClass())) {
                        called = true;
                        consumer.accept(clazz.cast(v));
                        break;
                    }
                }
            }
            if (!called) {
                consumer.accept(incompatibleValue.get());
            }
        };
    }

    @Override
    public void update() {
        if (this.plug != null) {
            this.consumer.accept(this.plug.get(this.request));
        } else {
            if (!this.initializerLoaded) {
                this.initializerValue = this.initializer.get();
                this.initializerLoaded = true;
            }
            this.consumer.accept(ValueResult.of(this.initializerValue));
        }
    }

}

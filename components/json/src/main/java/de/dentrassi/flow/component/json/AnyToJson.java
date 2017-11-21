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
package de.dentrassi.flow.component.json;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.spi.component.EventContext;
import de.dentrassi.flow.spi.component.SimpleTransformationComponent;

public class AnyToJson extends SimpleTransformationComponent<Object, String> {

    private Gson gson;

    public AnyToJson() {
        super(Object.class, String.class);
    }

    @Override
    public void start(final Map<String, String> initializers, final ComponentContext context,
            final EventContext event) {
        super.start(initializers, context, event);
        this.gson = new GsonBuilder().create();
    }

    @Override
    public String convertValue(final Object input) {
        return this.gson.toJson(input);
    }

}

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

import de.dentrassi.flow.ComponentInstance;

public final class MockComponentInstance implements ComponentInstance {

    public static final ComponentInstance MOCK = new MockComponentInstance();

    private MockComponentInstance() {
    }

    @Override
    public String getType() {
        return "mock";
    }

    @Override
    public String getId() {
        return "mock";
    }
}
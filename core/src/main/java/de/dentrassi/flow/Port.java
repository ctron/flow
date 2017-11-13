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
package de.dentrassi.flow;

import static java.util.Objects.requireNonNull;

public final class Port {
    private final ComponentInstance component;
    private final String portName;

    private Port(final ComponentInstance component, final String portName) {
        this.component = component;
        this.portName = portName;
    }

    public ComponentInstance getComponent() {
        return this.component;
    }

    public String getPortName() {
        return this.portName;
    }

    @Override
    public String toString() {
        return String.format("%s#%s", this.component, this.portName);
    }

    public static Port port(final ComponentInstance component, final String portName) {
        requireNonNull(component);
        requireNonNull(portName);

        return new Port(component, portName);
    }
}

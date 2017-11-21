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
package de.dentrassi.flow.event;

import de.dentrassi.flow.Port;
import de.dentrassi.flow.PortType;

public class AddPortState implements FlowEvent {

    private final Port port;
    private final PortType type;

    AddPortState(final Port port, final PortType type) {
        this.port = port;
        this.type = type;
    }

    public Port getPort() {
        return this.port;
    }

    @Override
    public String toString() {
        return new StringBuilder("[ADD_PORT - ")
                .append("Port: ").append(this.port).append(", ")
                .append("Port Type: ").append(this.type).append(", ")
                .append("]")
                .toString();
    }
}

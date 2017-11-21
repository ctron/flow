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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.dentrassi.flow.ComponentInstance;
import de.dentrassi.flow.Port;
import de.dentrassi.flow.PortType;

public interface FlowEvent {

    public static FlowEvent addComponent(final String id, final String type) {
        return new AddComponent(id, type);
    }

    public static FlowEvent addDataConnection(final String id, final Port out, final Port in) {
        return new AddDataConnection(id, out, in);
    }

    public static FlowEvent addTriggerConnection(final String id, final Port out, final Port in) {
        return new AddTriggerConnection(id, out, in);
    }

    public static FlowEvent addPort(final Port port, final PortType type) {
        return new AddPortState(port, type);
    }

    public static List<FlowEvent> addPorts(final ComponentInstance component,
            final Map<String, PortType> reportedPorts) {

        return reportedPorts
                .entrySet()
                .stream()
                .map(entry -> addPort(component.port(entry.getKey()), entry.getValue()))
                .collect(Collectors.toList());

    }

}

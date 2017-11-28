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
package de.dentrassi.flow.model;

import java.util.Optional;

import de.dentrassi.flow.PortType;
import de.dentrassi.flow.event.AddComponent;
import de.dentrassi.flow.event.AddConnection;
import de.dentrassi.flow.event.AddPort;
import de.dentrassi.flow.event.FlowEvent;
import de.dentrassi.flow.event.FlowListener;

public class ModelListener implements FlowListener {

    private final Flow flow;

    public ModelListener() {
        this.flow = FlowFactory.eINSTANCE.createFlow();
    }

    @Override
    public void flowEvent(final FlowEvent event) {
        if (event instanceof AddComponent) {
            addComponent((AddComponent) event);
        } else if (event instanceof AddPort) {
            addPort((AddPort) event);
        } else if (event instanceof AddConnection) {
            addConnection((AddConnection) event);
        }
    }

    private void addPort(final AddPort event) {
        final Optional<Node> component = component(event.getPort().getComponent().getId());

        component.ifPresent(n -> {
            final Port port = createPort(event.getPort(), event.getType());
            if (port != null) {
                n.getPorts().add(port);
            }
        });
    }

    private Optional<Node> component(final String id) {
        final Optional<Node> node = this.flow
                .getNodes()
                .stream()
                .filter(n -> n.getId().equals(id)).findFirst();
        return node;
    }

    private Port createPort(final de.dentrassi.flow.Port port, final PortType type) {

        switch (type) {
        case DATA_IN: {
            final Port result = FlowFactory.eINSTANCE.createDataInPort();
            result.setName(port.getPortName());
            return result;
        }
        case DATA_OUT: {
            final Port result = FlowFactory.eINSTANCE.createDataOutPort();
            result.setName(port.getPortName());
            return result;
        }
        case TRIGGER_IN: {
            final Port result = FlowFactory.eINSTANCE.createTriggerInPort();
            result.setName(port.getPortName());
            return result;
        }
        case TRIGGER_OUT: {
            final Port result = FlowFactory.eINSTANCE.createTriggerOutPort();
            result.setName(port.getPortName());
            return result;
        }
        default:
            return null;
        }
    }

    private void addComponent(final AddComponent event) {
        final Node node = FlowFactory.eINSTANCE.createNode();
        node.setId(event.getId());
        node.setType(event.getType());
        this.flow.getNodes().add(node);
    }

    private void addConnection(final AddConnection event) {

        switch (event.getConnectionType()) {
        case DATA: {
            final DataConnection connection = FlowFactory.eINSTANCE.createDataConnection();

            dataPortOut(event.getOut()).ifPresent(out -> {
                dataPortIn(event.getIn()).ifPresent(in -> {
                    connection.setOut(out);
                    connection.setIn(in);
                    this.flow.getConnections().add(connection);
                });
            });
        }
        case TRIGGER: {
            final TriggerConnection connection = FlowFactory.eINSTANCE.createTriggerConnection();

            triggerPortOut(event.getOut()).ifPresent(out -> {
                triggerPortIn(event.getIn()).ifPresent(in -> {
                    connection.setOut(out);
                    connection.setIn(in);
                    this.flow.getConnections().add(connection);
                });
            });
        }
        default:
            return;
        }

    }

    private Optional<DataInPort> dataPortIn(final de.dentrassi.flow.Port in) {
        final Optional<Node> component = component(in.getComponent().getId());
        return component.flatMap(c -> {
            return c.getPorts().stream().filter(p -> p instanceof DataInPort && p.getName().equals(in.getPortName()))
                    .map(p -> (DataInPort) p)
                    .findAny();
        });
    }

    private Optional<DataOutPort> dataPortOut(final de.dentrassi.flow.Port in) {
        final Optional<Node> component = component(in.getComponent().getId());
        return component.flatMap(c -> {
            return c.getPorts().stream().filter(p -> p instanceof DataOutPort && p.getName().equals(in.getPortName()))
                    .map(p -> (DataOutPort) p)
                    .findAny();
        });
    }

    private Optional<TriggerInPort> triggerPortIn(final de.dentrassi.flow.Port in) {
        final Optional<Node> component = component(in.getComponent().getId());
        return component.flatMap(c -> {
            return c.getPorts().stream().filter(p -> p instanceof TriggerInPort && p.getName().equals(in.getPortName()))
                    .map(p -> (TriggerInPort) p)
                    .findAny();
        });
    }

    private Optional<TriggerOutPort> triggerPortOut(final de.dentrassi.flow.Port in) {
        final Optional<Node> component = component(in.getComponent().getId());
        return component.flatMap(c -> {
            return c.getPorts().stream()
                    .filter(p -> p instanceof TriggerOutPort && p.getName().equals(in.getPortName()))
                    .map(p -> (TriggerOutPort) p)
                    .findAny();
        });
    }

    public Flow getFlow() {
        return this.flow;
    }

}

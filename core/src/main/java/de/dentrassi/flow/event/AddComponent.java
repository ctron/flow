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

public class AddComponent implements FlowEvent {

    private final String id;
    private final String type;

    AddComponent(final String id, final String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return new StringBuilder("[ADD_COMPONENT - ")
                .append("ID: ").append(this.id).append(", ")
                .append("Type: ").append(this.type)
                .append("]")
                .toString();
    }

}

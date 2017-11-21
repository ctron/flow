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

public class AddTriggerConnection extends AddConnection implements FlowEvent {

    AddTriggerConnection(final String id, final Port out, final Port in) {
        super(ConnectionType.TRIGGER, id, out, in);
    }

}

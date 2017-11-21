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

import java.util.Map;

public interface FlowContext extends ComponentInstance {

    public default ComponentInstance createComponent(final String componentType,
            final Map<String, String> initializers) {
        return createComponent(null, componentType, initializers);
    }

    public default ComponentInstance createComponent(final String componentType) {
        return createComponent(null, componentType, null);
    }

    public ComponentInstance createComponent(String id, String componentType, Map<String, String> initializers);

    public Connection connectTrigger(Port out, Port in);

    public default Connection connectData(final Port out, final Port in) {
        return connectData(out, in, Object.class);
    }

    public Connection connectData(Port out, Port in, Class<?> requiredType);

    public default Port triggerOutInit() {
        return Port.port(this, "init");
    }
}

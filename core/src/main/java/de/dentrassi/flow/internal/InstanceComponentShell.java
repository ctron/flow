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
package de.dentrassi.flow.internal;

import static java.util.Collections.emptyMap;

import de.dentrassi.flow.Component;
import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.ComponentInstance;
import de.dentrassi.flow.FlowContext;

public class InstanceComponentShell extends AbstractComponentShell {
    private final Component component;

    public InstanceComponentShell(final ComponentInstance instance, final Component component) {
        super(instance, emptyMap());
        this.component = component;
    }

    @Override
    public void start(final FlowContext flowContext, final ComponentContext componentContext) {
        super.start(flowContext, componentContext);
        setInstance(this.component);
    }
}

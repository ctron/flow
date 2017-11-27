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

import java.util.Map;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.ComponentInstance;
import de.dentrassi.flow.FlowContext;
import de.dentrassi.flow.spi.type.ComponentTypeProvider;
import de.dentrassi.flow.type.ComponentFactory;
import de.dentrassi.flow.type.ComponentFactory.LookupHandle;

public class FactoryComponentShell extends AbstractComponentShell {

    private final ComponentFactory componentFactory;
    private LookupHandle lookupHandle;

    public FactoryComponentShell(final ComponentFactory componentFactory, final ComponentInstance component,
            final Map<String, String> initializers) {

        super(component, initializers);

        this.componentFactory = componentFactory;
    }

    @Override
    public void start(final FlowContext flowContext, final ComponentContext componentContext) {
        super.start(flowContext, componentContext);
        this.lookupHandle = this.componentFactory.lookup(getComponent().getType(), this::typeProviderChanged);
    }

    @Override
    public void stop() {
        if (this.lookupHandle != null) {
            this.lookupHandle.close();
            this.lookupHandle = null;
        }
        super.stop();
    }

    protected void typeProviderChanged(final ComponentTypeProvider typeProvider) {
        if (typeProvider == null) {
            setInstance(null);
        } else {
            try {
                setInstance(typeProvider.createType(getComponent().getType()));
            } catch (final Exception e) {
                setErrorInstance(e);
            }
        }
    }

}

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
import de.dentrassi.flow.FlowContext;
import de.dentrassi.flow.spi.type.ComponentFactory;
import de.dentrassi.flow.spi.type.ComponentFactory.LookupHandle;
import de.dentrassi.flow.spi.type.ComponentTypeProvider;

public class FactoryComponentShell extends AbstractComponentShell {

    private final ComponentFactory componentFactory;
    private final String componentType;
    private LookupHandle lookupHandle;

    public FactoryComponentShell(final ComponentFactory componentFactory, final String componentType,
            final Map<String, String> initializers) {

        super(initializers);

        this.componentFactory = componentFactory;
        this.componentType = componentType;
    }

    @Override
    public void start(final FlowContext flowContext, final ComponentContext componentContext) {
        super.start(flowContext, componentContext);
        this.lookupHandle = this.componentFactory.lookup(this.componentType, this::typeProviderChanged);
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
                setInstance(typeProvider.createType(this.componentType));
            } catch (final Exception e) {
                setErrorInstance(e);
            }
        }
    }

}

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
package de.dentrassi.flow.spi.component;

import java.util.Objects;

import de.dentrassi.flow.spi.DataPlugIn;

public abstract class AbstractSingleDataPortIn implements DataPortIn {

    protected DataPlugIn plug;

    @Override
    public void add(final DataPlugIn plug) {
        Objects.requireNonNull(plug);

        // we only support one plug

        if (this.plug != null) {
            throw new IllegalStateException("Port already connected");
        }

        this.plug = plug;
    }

    @Override
    public void remove(final DataPlugIn plug) {

        // we only support one plug

        if (this.plug == plug) {
            this.plug = null;
        }
    }
}

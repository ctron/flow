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

import de.dentrassi.flow.Port;
import de.dentrassi.flow.spi.DataPlugIn;
import de.dentrassi.flow.spi.DataPlugOut;
import de.dentrassi.flow.spi.component.DataPortOut;
import de.dentrassi.flow.spi.component.ValueRequest;
import de.dentrassi.flow.spi.component.ValueResult;

public class FlowDataConnection {

    private final DataPlugIn in = new DataPlugIn() {

        @Override
        public ValueResult get() {
            return FlowDataConnection.this.get();
        }
    };

    private final DataPlugOut out = new DataPlugOut() {

        @Override
        public void setSupplier(final DataPortOut plug) {
            FlowDataConnection.this.supplier = plug;
        }
    };

    private final Port outPort;

    private final Port inPort;

    private final ValueRequest request;

    protected DataPortOut supplier;

    public FlowDataConnection(final Port out, final Port in, final Class<?> requiredType) {
        this.outPort = out;
        this.inPort = in;
        this.request = ValueRequest.of(requiredType);
    }

    protected ValueResult get() {
        return this.supplier.get(this.request);
    }

    public DataPlugOut out() {
        return this.out;
    }

    public DataPlugIn in() {
        return this.in;
    }

    public Port getOutPort() {
        return this.outPort;
    }

    public Port getInPort() {
        return this.inPort;
    }
}

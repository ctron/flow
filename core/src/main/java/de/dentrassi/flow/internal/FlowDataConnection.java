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

import static java.lang.String.format;

import de.dentrassi.flow.Port;
import de.dentrassi.flow.spi.DataPlugIn;
import de.dentrassi.flow.spi.DataPlugOut;
import de.dentrassi.flow.spi.component.DataPortOut;
import de.dentrassi.flow.spi.component.ValueRequest;
import de.dentrassi.flow.spi.component.ValueResult;

public class FlowDataConnection {

    private final DataPlugIn in = new DataPlugIn() {

        @Override
        public ValueResult get(final ValueRequest request) {
            return FlowDataConnection.this.get(request);
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

    private final Class<?> requiredType;

    protected DataPortOut supplier;

    private ValueRequest lastIncomingRequest;
    private ValueRequest lastOutgoingRequest;

    public FlowDataConnection(final Port out, final Port in, final Class<?> requiredType) {
        this.outPort = out;
        this.inPort = in;
        this.requiredType = requiredType;
    }

    protected ValueResult get(final ValueRequest request) {

        if (this.requiredType == null) {

            // this connection is not limited to a type ... pass through
            return this.supplier.get(request);

        } else {

            // check if we have the same instance

            if (this.lastIncomingRequest != request) {

                // no ... we need to re-eval

                this.lastOutgoingRequest = request.limit(this.requiredType);
                this.lastIncomingRequest = request;
            }

            if (this.lastOutgoingRequest == null) {

                // if there is no matching type

                throw new ClassCastException(
                        format("Unable to limit request by %s - possible types: %s", this.requiredType, request));
            }

            // pass on request

            return this.supplier.get(this.lastOutgoingRequest);
        }
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

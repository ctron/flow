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

public class SimpleSingleDataPortIn extends AbstractSingleDataPortIn {

    private ValueResult value;

    private Throwable error;

    @Override
    public void update() {
        this.error = null;
        if (this.plug != null) {
            try {
                this.value = this.plug.get();
            } catch (final Throwable e) {
                this.error = e;
            }
        } else {
            this.value = ValueResult.of();
        }
    }

    public ValueResult getValue() {
        return this.value;
    }

    public Throwable getError() {
        return this.error;
    }

}

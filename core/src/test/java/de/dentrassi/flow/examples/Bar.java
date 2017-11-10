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
package de.dentrassi.flow.examples;

import de.dentrassi.flow.spi.component.AbstractComponent;

public class Bar extends AbstractComponent {

    private Object message;

    public Bar() {
        registerTriggerIn("output", this::output);
        registerDataIn("message", () -> null, this::setMessage);
    }

    // @TriggerIn
    public void output() {
        updateAllData();
        System.out.format("output: %s%n", this.message);
    }

    // @DataIn
    public void setMessage(final Object message) {
        this.message = message;
    }
}

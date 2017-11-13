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

public class Foo extends AbstractComponent {

    private String message;

    public Foo() {
        registerTriggerIn("execute", this::execute);
        registerTriggerOut("changed");

        registerDataIn("messageIn", String.class, () -> getInitializer("messageIn"), this::setMessage);
        registerDataOut("messageOut", this::getMessage);
    }

    // @TriggerOut
    public void changed() {
    }

    // @TriggerIn
    public void execute() {
        updateAllData();
        triggerOut("changed");
    }

    // @DataIn("messageIn")
    public void setMessage(final String message) {
        this.message = message;
    }

    // @DataOut("messageOut")
    public String getMessage() {
        return "Foo bar: " + this.message;
    }

}

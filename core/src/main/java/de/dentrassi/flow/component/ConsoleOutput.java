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
package de.dentrassi.flow.component;

import de.dentrassi.flow.spi.component.AnnotatedComponent;
import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.TriggerIn;

public class ConsoleOutput extends AnnotatedComponent {

    private String format;
    private Object value;

    @DataIn
    public void setFormat(final String format) {
        this.format = format;
    }

    @DataIn
    public void setValue(final Object value) {
        this.value = value;
    }

    @TriggerIn
    public void execute() {
        if (this.format == null) {
            System.out.println(this.value);
        } else {
            System.out.format(this.format, this.value);
        }
    }

}

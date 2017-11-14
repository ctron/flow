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
package de.dentrassi.flow.component.trigger;

import de.dentrassi.flow.spi.component.AnnotatedComponent;
import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.TriggerIn;
import de.dentrassi.flow.spi.component.TriggerOut;

public class Permit extends AnnotatedComponent {

    private boolean permit;

    private Runnable output;

    @TriggerOut
    public void setOutput(final Runnable output) {
        this.output = output;
    }

    @DataIn
    public void setPermit(final Boolean permit) {
        this.permit = permit != null ? permit : false;
    }

    @TriggerIn
    public void input() {
        if (this.permit) {
            this.output.run();
        }
    }

}

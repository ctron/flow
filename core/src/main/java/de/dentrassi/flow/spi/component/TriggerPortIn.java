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

import de.dentrassi.flow.spi.TriggerPlugIn;

public class TriggerPortIn {

    private final Runnable runnable;

    public TriggerPortIn(final Runnable runnable) {
        this.runnable = runnable;
    }

    public void add(final TriggerPlugIn plug) {
        plug.subscribe(this.runnable);
    }

    public void remove(final TriggerPlugIn plug) {
        plug.unsubscribe(this.runnable);
    }
}

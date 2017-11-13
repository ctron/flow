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

import java.util.HashSet;
import java.util.Set;

import de.dentrassi.flow.spi.TriggerPlugOut;

public class TriggerPortOut {

    private final Set<TriggerPlugOut> plugs = new HashSet<>();

    public void execute() {
        this.plugs.forEach(TriggerPlugOut::execute);
    }

    public void add(final TriggerPlugOut plug) {
        this.plugs.add(plug);
    }

    public void remove(final TriggerPlugOut plug) {
        this.plugs.remove(plug);
    }
}

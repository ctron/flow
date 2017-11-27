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
package de.dentrassi.flow.spi;

import java.util.Map;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.spi.component.EventContext;

public interface Component {

    public void start(Map<String, String> initializers, ComponentContext context, EventContext event);

    public void stop();

    public void connectTriggerIn(String portName, TriggerPlugIn plug);

    public void connectTriggerOut(String portName, TriggerPlugOut plug);

    public void connectDataIn(String portName, DataPlugIn plug);

    public void connectDataOut(String portName, DataPlugOut plug);

}

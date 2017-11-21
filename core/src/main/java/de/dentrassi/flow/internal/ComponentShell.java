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

import java.util.Map;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.ComponentInstance;
import de.dentrassi.flow.FlowContext;
import de.dentrassi.flow.PortType;
import de.dentrassi.flow.spi.DataPlugIn;
import de.dentrassi.flow.spi.DataPlugOut;
import de.dentrassi.flow.spi.TriggerPlugIn;
import de.dentrassi.flow.spi.TriggerPlugOut;

public interface ComponentShell {

    public ComponentInstance getComponent();

    public void start(FlowContext flowContext, final ComponentContext componentContext);

    public void stop();

    public void addDataInConnection(String portName, DataPlugIn in);

    public void addDataOutConnection(String portName, DataPlugOut out);

    public void addTriggerInConnection(String portName, TriggerPlugIn in);

    public void addTriggerOutConnection(String portName, TriggerPlugOut out);

    public Map<String, PortType> getReportedPorts();

}

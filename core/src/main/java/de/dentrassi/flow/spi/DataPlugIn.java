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

import de.dentrassi.flow.spi.component.ValueRequest;
import de.dentrassi.flow.spi.component.ValueResult;

public interface DataPlugIn {

    public ValueResult get(ValueRequest request);

}

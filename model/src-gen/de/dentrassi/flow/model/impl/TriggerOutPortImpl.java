/**
 * Copyright (c) 2017 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jens Reimann - initial API and implementation
 */
package de.dentrassi.flow.model.impl;

import de.dentrassi.flow.model.FlowPackage;
import de.dentrassi.flow.model.TriggerOutPort;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger Out Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TriggerOutPortImpl extends PortImpl implements TriggerOutPort {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TriggerOutPortImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FlowPackage.Literals.TRIGGER_OUT_PORT;
    }

} //TriggerOutPortImpl

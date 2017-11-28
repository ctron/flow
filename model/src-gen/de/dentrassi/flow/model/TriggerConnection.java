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
package de.dentrassi.flow.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.TriggerConnection#getIn <em>In</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.TriggerConnection#getOut <em>Out</em>}</li>
 * </ul>
 *
 * @see de.dentrassi.flow.model.FlowPackage#getTriggerConnection()
 * @model
 * @generated
 */
public interface TriggerConnection extends Connection {
    /**
     * Returns the value of the '<em><b>In</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In</em>' reference.
     * @see #setIn(TriggerInPort)
     * @see de.dentrassi.flow.model.FlowPackage#getTriggerConnection_In()
     * @model required="true"
     * @generated
     */
    TriggerInPort getIn();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.TriggerConnection#getIn <em>In</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>In</em>' reference.
     * @see #getIn()
     * @generated
     */
    void setIn(TriggerInPort value);

    /**
     * Returns the value of the '<em><b>Out</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out</em>' reference.
     * @see #setOut(TriggerOutPort)
     * @see de.dentrassi.flow.model.FlowPackage#getTriggerConnection_Out()
     * @model required="true"
     * @generated
     */
    TriggerOutPort getOut();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.TriggerConnection#getOut <em>Out</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Out</em>' reference.
     * @see #getOut()
     * @generated
     */
    void setOut(TriggerOutPort value);

} // TriggerConnection

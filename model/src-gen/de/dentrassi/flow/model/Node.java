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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.Node#getId <em>Id</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.Node#getType <em>Type</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.Node#getPorts <em>Ports</em>}</li>
 * </ul>
 *
 * @see de.dentrassi.flow.model.FlowPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see de.dentrassi.flow.model.FlowPackage#getNode_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.Node#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see de.dentrassi.flow.model.FlowPackage#getNode_Type()
     * @model required="true"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.Node#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Ports</b></em>' reference list.
     * The list contents are of type {@link de.dentrassi.flow.model.Port}.
     * It is bidirectional and its opposite is '{@link de.dentrassi.flow.model.Port#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ports</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ports</em>' reference list.
     * @see de.dentrassi.flow.model.FlowPackage#getNode_Ports()
     * @see de.dentrassi.flow.model.Port#getNode
     * @model opposite="node"
     * @generated
     */
    EList<Port> getPorts();

} // Node

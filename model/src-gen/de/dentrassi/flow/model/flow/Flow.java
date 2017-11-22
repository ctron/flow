/**
 */
package de.dentrassi.flow.model.flow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.flow.Flow#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.flow.Flow#getConnections <em>Connections</em>}</li>
 * </ul>
 *
 * @see de.dentrassi.flow.model.flow.FlowPackage#getFlow()
 * @model
 * @generated
 */
public interface Flow extends EObject {
    /**
     * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
     * The list contents are of type {@link de.dentrassi.flow.model.flow.Node}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nodes</em>' containment reference list.
     * @see de.dentrassi.flow.model.flow.FlowPackage#getFlow_Nodes()
     * @model containment="true"
     * @generated
     */
    EList<Node> getNodes();

    /**
     * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
     * The list contents are of type {@link de.dentrassi.flow.model.flow.Connection}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connections</em>' containment reference list.
     * @see de.dentrassi.flow.model.flow.FlowPackage#getFlow_Connections()
     * @model containment="true"
     * @generated
     */
    EList<Connection> getConnections();

} // Flow

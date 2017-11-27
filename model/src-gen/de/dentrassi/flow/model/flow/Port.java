/**
 */
package de.dentrassi.flow.model.flow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.flow.Port#getName <em>Name</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.flow.Port#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see de.dentrassi.flow.model.flow.FlowPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.dentrassi.flow.model.flow.FlowPackage#getPort_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.flow.Port#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Node</b></em>' reference.
     * It is bidirectional and its opposite is '{@link de.dentrassi.flow.model.flow.Node#getPorts <em>Ports</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Node</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Node</em>' reference.
     * @see #setNode(Node)
     * @see de.dentrassi.flow.model.flow.FlowPackage#getPort_Node()
     * @see de.dentrassi.flow.model.flow.Node#getPorts
     * @model opposite="ports" required="true"
     * @generated
     */
    Node getNode();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.flow.Port#getNode <em>Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Node</em>' reference.
     * @see #getNode()
     * @generated
     */
    void setNode(Node value);

} // Port

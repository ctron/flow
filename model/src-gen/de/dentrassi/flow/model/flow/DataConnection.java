/**
 */
package de.dentrassi.flow.model.flow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.flow.DataConnection#getIn <em>In</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.flow.DataConnection#getOut <em>Out</em>}</li>
 * </ul>
 *
 * @see de.dentrassi.flow.model.flow.FlowPackage#getDataConnection()
 * @model
 * @generated
 */
public interface DataConnection extends Connection {
    /**
     * Returns the value of the '<em><b>In</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In</em>' reference.
     * @see #setIn(DataInPort)
     * @see de.dentrassi.flow.model.flow.FlowPackage#getDataConnection_In()
     * @model required="true"
     * @generated
     */
    DataInPort getIn();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.flow.DataConnection#getIn <em>In</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>In</em>' reference.
     * @see #getIn()
     * @generated
     */
    void setIn(DataInPort value);

    /**
     * Returns the value of the '<em><b>Out</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out</em>' reference.
     * @see #setOut(DataOutPort)
     * @see de.dentrassi.flow.model.flow.FlowPackage#getDataConnection_Out()
     * @model required="true"
     * @generated
     */
    DataOutPort getOut();

    /**
     * Sets the value of the '{@link de.dentrassi.flow.model.flow.DataConnection#getOut <em>Out</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Out</em>' reference.
     * @see #getOut()
     * @generated
     */
    void setOut(DataOutPort value);

} // DataConnection

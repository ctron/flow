/**
 */
package de.dentrassi.flow.model.flow;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.dentrassi.flow.model.flow.FlowPackage
 * @generated
 */
public interface FlowFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FlowFactory eINSTANCE = de.dentrassi.flow.model.flow.impl.FlowFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Flow</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Flow</em>'.
     * @generated
     */
    Flow createFlow();

    /**
     * Returns a new object of class '<em>Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Node</em>'.
     * @generated
     */
    Node createNode();

    /**
     * Returns a new object of class '<em>Data In Port</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data In Port</em>'.
     * @generated
     */
    DataInPort createDataInPort();

    /**
     * Returns a new object of class '<em>Data Out Port</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Out Port</em>'.
     * @generated
     */
    DataOutPort createDataOutPort();

    /**
     * Returns a new object of class '<em>Trigger In Port</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trigger In Port</em>'.
     * @generated
     */
    TriggerInPort createTriggerInPort();

    /**
     * Returns a new object of class '<em>Trigger Out Port</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trigger Out Port</em>'.
     * @generated
     */
    TriggerOutPort createTriggerOutPort();

    /**
     * Returns a new object of class '<em>Data Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Connection</em>'.
     * @generated
     */
    DataConnection createDataConnection();

    /**
     * Returns a new object of class '<em>Trigger Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trigger Connection</em>'.
     * @generated
     */
    TriggerConnection createTriggerConnection();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    FlowPackage getFlowPackage();

} //FlowFactory

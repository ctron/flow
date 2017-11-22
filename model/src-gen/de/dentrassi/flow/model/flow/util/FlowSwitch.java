/**
 */
package de.dentrassi.flow.model.flow.util;

import de.dentrassi.flow.model.flow.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.dentrassi.flow.model.flow.FlowPackage
 * @generated
 */
public class FlowSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static FlowPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FlowSwitch() {
        if (modelPackage == null) {
            modelPackage = FlowPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case FlowPackage.FLOW: {
            Flow flow = (Flow) theEObject;
            T result = caseFlow(flow);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.NODE: {
            Node node = (Node) theEObject;
            T result = caseNode(node);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.PORT: {
            Port port = (Port) theEObject;
            T result = casePort(port);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.DATA_IN_PORT: {
            DataInPort dataInPort = (DataInPort) theEObject;
            T result = caseDataInPort(dataInPort);
            if (result == null)
                result = casePort(dataInPort);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.DATA_OUT_PORT: {
            DataOutPort dataOutPort = (DataOutPort) theEObject;
            T result = caseDataOutPort(dataOutPort);
            if (result == null)
                result = casePort(dataOutPort);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.TRIGGER_IN_PORT: {
            TriggerInPort triggerInPort = (TriggerInPort) theEObject;
            T result = caseTriggerInPort(triggerInPort);
            if (result == null)
                result = casePort(triggerInPort);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.TRIGGER_OUT_PORT: {
            TriggerOutPort triggerOutPort = (TriggerOutPort) theEObject;
            T result = caseTriggerOutPort(triggerOutPort);
            if (result == null)
                result = casePort(triggerOutPort);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.CONNECTION: {
            Connection connection = (Connection) theEObject;
            T result = caseConnection(connection);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.DATA_CONNECTION: {
            DataConnection dataConnection = (DataConnection) theEObject;
            T result = caseDataConnection(dataConnection);
            if (result == null)
                result = caseConnection(dataConnection);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case FlowPackage.TRIGGER_CONNECTION: {
            TriggerConnection triggerConnection = (TriggerConnection) theEObject;
            T result = caseTriggerConnection(triggerConnection);
            if (result == null)
                result = caseConnection(triggerConnection);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFlow(Flow object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNode(Node object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePort(Port object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data In Port</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data In Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataInPort(DataInPort object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Out Port</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Out Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataOutPort(DataOutPort object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Trigger In Port</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trigger In Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTriggerInPort(TriggerInPort object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Trigger Out Port</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trigger Out Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTriggerOutPort(TriggerOutPort object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnection(Connection object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataConnection(DataConnection object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Trigger Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trigger Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTriggerConnection(TriggerConnection object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //FlowSwitch

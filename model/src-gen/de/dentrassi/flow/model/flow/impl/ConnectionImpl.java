/**
 */
package de.dentrassi.flow.model.flow.impl;

import de.dentrassi.flow.model.flow.Connection;
import de.dentrassi.flow.model.flow.FlowPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ConnectionImpl extends MinimalEObjectImpl.Container implements Connection {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConnectionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FlowPackage.Literals.CONNECTION;
    }

} //ConnectionImpl

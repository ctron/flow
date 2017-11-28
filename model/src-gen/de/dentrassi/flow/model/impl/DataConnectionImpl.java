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

import de.dentrassi.flow.model.DataConnection;
import de.dentrassi.flow.model.DataInPort;
import de.dentrassi.flow.model.DataOutPort;
import de.dentrassi.flow.model.FlowPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.impl.DataConnectionImpl#getIn <em>In</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.impl.DataConnectionImpl#getOut <em>Out</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataConnectionImpl extends ConnectionImpl implements DataConnection {
    /**
     * The cached value of the '{@link #getIn() <em>In</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn()
     * @generated
     * @ordered
     */
    protected DataInPort in;

    /**
     * The cached value of the '{@link #getOut() <em>Out</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut()
     * @generated
     * @ordered
     */
    protected DataOutPort out;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataConnectionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FlowPackage.Literals.DATA_CONNECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataInPort getIn() {
        if (in != null && in.eIsProxy()) {
            InternalEObject oldIn = (InternalEObject) in;
            in = (DataInPort) eResolveProxy(oldIn);
            if (in != oldIn) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowPackage.DATA_CONNECTION__IN, oldIn,
                            in));
            }
        }
        return in;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataInPort basicGetIn() {
        return in;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIn(DataInPort newIn) {
        DataInPort oldIn = in;
        in = newIn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FlowPackage.DATA_CONNECTION__IN, oldIn, in));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOutPort getOut() {
        if (out != null && out.eIsProxy()) {
            InternalEObject oldOut = (InternalEObject) out;
            out = (DataOutPort) eResolveProxy(oldOut);
            if (out != oldOut) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowPackage.DATA_CONNECTION__OUT, oldOut,
                            out));
            }
        }
        return out;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOutPort basicGetOut() {
        return out;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOut(DataOutPort newOut) {
        DataOutPort oldOut = out;
        out = newOut;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FlowPackage.DATA_CONNECTION__OUT, oldOut, out));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case FlowPackage.DATA_CONNECTION__IN:
            if (resolve)
                return getIn();
            return basicGetIn();
        case FlowPackage.DATA_CONNECTION__OUT:
            if (resolve)
                return getOut();
            return basicGetOut();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case FlowPackage.DATA_CONNECTION__IN:
            setIn((DataInPort) newValue);
            return;
        case FlowPackage.DATA_CONNECTION__OUT:
            setOut((DataOutPort) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case FlowPackage.DATA_CONNECTION__IN:
            setIn((DataInPort) null);
            return;
        case FlowPackage.DATA_CONNECTION__OUT:
            setOut((DataOutPort) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case FlowPackage.DATA_CONNECTION__IN:
            return in != null;
        case FlowPackage.DATA_CONNECTION__OUT:
            return out != null;
        }
        return super.eIsSet(featureID);
    }

} //DataConnectionImpl

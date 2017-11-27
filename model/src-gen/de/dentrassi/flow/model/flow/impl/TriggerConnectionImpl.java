/**
 */
package de.dentrassi.flow.model.flow.impl;

import de.dentrassi.flow.model.flow.FlowPackage;
import de.dentrassi.flow.model.flow.TriggerConnection;
import de.dentrassi.flow.model.flow.TriggerInPort;
import de.dentrassi.flow.model.flow.TriggerOutPort;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.flow.impl.TriggerConnectionImpl#getIn <em>In</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.flow.impl.TriggerConnectionImpl#getOut <em>Out</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriggerConnectionImpl extends ConnectionImpl implements TriggerConnection {
    /**
     * The cached value of the '{@link #getIn() <em>In</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn()
     * @generated
     * @ordered
     */
    protected TriggerInPort in;

    /**
     * The cached value of the '{@link #getOut() <em>Out</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut()
     * @generated
     * @ordered
     */
    protected TriggerOutPort out;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TriggerConnectionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FlowPackage.Literals.TRIGGER_CONNECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerInPort getIn() {
        if (in != null && in.eIsProxy()) {
            InternalEObject oldIn = (InternalEObject) in;
            in = (TriggerInPort) eResolveProxy(oldIn);
            if (in != oldIn) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowPackage.TRIGGER_CONNECTION__IN, oldIn,
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
    public TriggerInPort basicGetIn() {
        return in;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIn(TriggerInPort newIn) {
        TriggerInPort oldIn = in;
        in = newIn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FlowPackage.TRIGGER_CONNECTION__IN, oldIn, in));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerOutPort getOut() {
        if (out != null && out.eIsProxy()) {
            InternalEObject oldOut = (InternalEObject) out;
            out = (TriggerOutPort) eResolveProxy(oldOut);
            if (out != oldOut) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowPackage.TRIGGER_CONNECTION__OUT,
                            oldOut, out));
            }
        }
        return out;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerOutPort basicGetOut() {
        return out;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOut(TriggerOutPort newOut) {
        TriggerOutPort oldOut = out;
        out = newOut;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FlowPackage.TRIGGER_CONNECTION__OUT, oldOut, out));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case FlowPackage.TRIGGER_CONNECTION__IN:
            if (resolve)
                return getIn();
            return basicGetIn();
        case FlowPackage.TRIGGER_CONNECTION__OUT:
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
        case FlowPackage.TRIGGER_CONNECTION__IN:
            setIn((TriggerInPort) newValue);
            return;
        case FlowPackage.TRIGGER_CONNECTION__OUT:
            setOut((TriggerOutPort) newValue);
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
        case FlowPackage.TRIGGER_CONNECTION__IN:
            setIn((TriggerInPort) null);
            return;
        case FlowPackage.TRIGGER_CONNECTION__OUT:
            setOut((TriggerOutPort) null);
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
        case FlowPackage.TRIGGER_CONNECTION__IN:
            return in != null;
        case FlowPackage.TRIGGER_CONNECTION__OUT:
            return out != null;
        }
        return super.eIsSet(featureID);
    }

} //TriggerConnectionImpl

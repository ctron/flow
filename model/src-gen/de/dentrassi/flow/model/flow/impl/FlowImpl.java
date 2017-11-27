/**
 */
package de.dentrassi.flow.model.flow.impl;

import de.dentrassi.flow.model.flow.Connection;
import de.dentrassi.flow.model.flow.Flow;
import de.dentrassi.flow.model.flow.FlowPackage;
import de.dentrassi.flow.model.flow.Node;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dentrassi.flow.model.flow.impl.FlowImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.dentrassi.flow.model.flow.impl.FlowImpl#getConnections <em>Connections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowImpl extends MinimalEObjectImpl.Container implements Flow {
    /**
     * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNodes()
     * @generated
     * @ordered
     */
    protected EList<Node> nodes;

    /**
     * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnections()
     * @generated
     * @ordered
     */
    protected EList<Connection> connections;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FlowImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FlowPackage.Literals.FLOW;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Node> getNodes() {
        if (nodes == null) {
            nodes = new EObjectContainmentEList<Node>(Node.class, this, FlowPackage.FLOW__NODES);
        }
        return nodes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getConnections() {
        if (connections == null) {
            connections = new EObjectContainmentEList<Connection>(Connection.class, this,
                    FlowPackage.FLOW__CONNECTIONS);
        }
        return connections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case FlowPackage.FLOW__NODES:
            return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
        case FlowPackage.FLOW__CONNECTIONS:
            return ((InternalEList<?>) getConnections()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case FlowPackage.FLOW__NODES:
            return getNodes();
        case FlowPackage.FLOW__CONNECTIONS:
            return getConnections();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case FlowPackage.FLOW__NODES:
            getNodes().clear();
            getNodes().addAll((Collection<? extends Node>) newValue);
            return;
        case FlowPackage.FLOW__CONNECTIONS:
            getConnections().clear();
            getConnections().addAll((Collection<? extends Connection>) newValue);
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
        case FlowPackage.FLOW__NODES:
            getNodes().clear();
            return;
        case FlowPackage.FLOW__CONNECTIONS:
            getConnections().clear();
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
        case FlowPackage.FLOW__NODES:
            return nodes != null && !nodes.isEmpty();
        case FlowPackage.FLOW__CONNECTIONS:
            return connections != null && !connections.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //FlowImpl

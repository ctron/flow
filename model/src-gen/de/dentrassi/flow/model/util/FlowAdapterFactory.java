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
package de.dentrassi.flow.model.util;

import de.dentrassi.flow.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.dentrassi.flow.model.FlowPackage
 * @generated
 */
public class FlowAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static FlowPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FlowAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = FlowPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FlowSwitch<Adapter> modelSwitch = new FlowSwitch<Adapter>() {
        @Override
        public Adapter caseFlow(Flow object) {
            return createFlowAdapter();
        }

        @Override
        public Adapter caseNode(Node object) {
            return createNodeAdapter();
        }

        @Override
        public Adapter casePort(Port object) {
            return createPortAdapter();
        }

        @Override
        public Adapter caseDataInPort(DataInPort object) {
            return createDataInPortAdapter();
        }

        @Override
        public Adapter caseDataOutPort(DataOutPort object) {
            return createDataOutPortAdapter();
        }

        @Override
        public Adapter caseTriggerInPort(TriggerInPort object) {
            return createTriggerInPortAdapter();
        }

        @Override
        public Adapter caseTriggerOutPort(TriggerOutPort object) {
            return createTriggerOutPortAdapter();
        }

        @Override
        public Adapter caseConnection(Connection object) {
            return createConnectionAdapter();
        }

        @Override
        public Adapter caseDataConnection(DataConnection object) {
            return createDataConnectionAdapter();
        }

        @Override
        public Adapter caseTriggerConnection(TriggerConnection object) {
            return createTriggerConnectionAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.Flow <em>Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.Flow
     * @generated
     */
    public Adapter createFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.Node
     * @generated
     */
    public Adapter createNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.Port <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.Port
     * @generated
     */
    public Adapter createPortAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.DataInPort <em>Data In Port</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.DataInPort
     * @generated
     */
    public Adapter createDataInPortAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.DataOutPort <em>Data Out Port</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.DataOutPort
     * @generated
     */
    public Adapter createDataOutPortAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.TriggerInPort <em>Trigger In Port</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.TriggerInPort
     * @generated
     */
    public Adapter createTriggerInPortAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.TriggerOutPort <em>Trigger Out Port</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.TriggerOutPort
     * @generated
     */
    public Adapter createTriggerOutPortAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.Connection
     * @generated
     */
    public Adapter createConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.DataConnection <em>Data Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.DataConnection
     * @generated
     */
    public Adapter createDataConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.dentrassi.flow.model.TriggerConnection <em>Trigger Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.dentrassi.flow.model.TriggerConnection
     * @generated
     */
    public Adapter createTriggerConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //FlowAdapterFactory

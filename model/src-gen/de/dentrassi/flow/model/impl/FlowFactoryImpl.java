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

import de.dentrassi.flow.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowFactoryImpl extends EFactoryImpl implements FlowFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FlowFactory init() {
        try {
            FlowFactory theFlowFactory = (FlowFactory) EPackage.Registry.INSTANCE.getEFactory(FlowPackage.eNS_URI);
            if (theFlowFactory != null) {
                return theFlowFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FlowFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FlowFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case FlowPackage.FLOW:
            return createFlow();
        case FlowPackage.NODE:
            return createNode();
        case FlowPackage.DATA_IN_PORT:
            return createDataInPort();
        case FlowPackage.DATA_OUT_PORT:
            return createDataOutPort();
        case FlowPackage.TRIGGER_IN_PORT:
            return createTriggerInPort();
        case FlowPackage.TRIGGER_OUT_PORT:
            return createTriggerOutPort();
        case FlowPackage.DATA_CONNECTION:
            return createDataConnection();
        case FlowPackage.TRIGGER_CONNECTION:
            return createTriggerConnection();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Flow createFlow() {
        FlowImpl flow = new FlowImpl();
        return flow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Node createNode() {
        NodeImpl node = new NodeImpl();
        return node;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataInPort createDataInPort() {
        DataInPortImpl dataInPort = new DataInPortImpl();
        return dataInPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOutPort createDataOutPort() {
        DataOutPortImpl dataOutPort = new DataOutPortImpl();
        return dataOutPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerInPort createTriggerInPort() {
        TriggerInPortImpl triggerInPort = new TriggerInPortImpl();
        return triggerInPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerOutPort createTriggerOutPort() {
        TriggerOutPortImpl triggerOutPort = new TriggerOutPortImpl();
        return triggerOutPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataConnection createDataConnection() {
        DataConnectionImpl dataConnection = new DataConnectionImpl();
        return dataConnection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerConnection createTriggerConnection() {
        TriggerConnectionImpl triggerConnection = new TriggerConnectionImpl();
        return triggerConnection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FlowPackage getFlowPackage() {
        return (FlowPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static FlowPackage getPackage() {
        return FlowPackage.eINSTANCE;
    }

} //FlowFactoryImpl

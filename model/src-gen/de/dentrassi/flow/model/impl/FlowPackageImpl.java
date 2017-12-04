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

import de.dentrassi.flow.model.Connection;
import de.dentrassi.flow.model.DataConnection;
import de.dentrassi.flow.model.DataInPort;
import de.dentrassi.flow.model.DataOutPort;
import de.dentrassi.flow.model.Flow;
import de.dentrassi.flow.model.FlowFactory;
import de.dentrassi.flow.model.FlowPackage;
import de.dentrassi.flow.model.Node;
import de.dentrassi.flow.model.Port;
import de.dentrassi.flow.model.TriggerConnection;
import de.dentrassi.flow.model.TriggerInPort;
import de.dentrassi.flow.model.TriggerOutPort;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowPackageImpl extends EPackageImpl implements FlowPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass flowEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass portEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataInPortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataOutPortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerInPortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerOutPortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerConnectionEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.dentrassi.flow.model.FlowPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private FlowPackageImpl() {
        super(eNS_URI, FlowFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link FlowPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static FlowPackage init() {
        if (isInited)
            return (FlowPackage) EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);

        // Obtain or create and register package
        FlowPackageImpl theFlowPackage = (FlowPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof FlowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new FlowPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theFlowPackage.createPackageContents();

        // Initialize created meta-data
        theFlowPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFlowPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(FlowPackage.eNS_URI, theFlowPackage);
        return theFlowPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFlow() {
        return flowEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFlow_Nodes() {
        return (EReference) flowEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFlow_Connections() {
        return (EReference) flowEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNode() {
        return nodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNode_Id() {
        return (EAttribute) nodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNode_Type() {
        return (EAttribute) nodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNode_Ports() {
        return (EReference) nodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPort() {
        return portEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPort_Name() {
        return (EAttribute) portEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPort_Node() {
        return (EReference) portEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataInPort() {
        return dataInPortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataOutPort() {
        return dataOutPortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTriggerInPort() {
        return triggerInPortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTriggerOutPort() {
        return triggerOutPortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnection() {
        return connectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataConnection() {
        return dataConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataConnection_In() {
        return (EReference) dataConnectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataConnection_Out() {
        return (EReference) dataConnectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTriggerConnection() {
        return triggerConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTriggerConnection_In() {
        return (EReference) triggerConnectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTriggerConnection_Out() {
        return (EReference) triggerConnectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FlowFactory getFlowFactory() {
        return (FlowFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        flowEClass = createEClass(FLOW);
        createEReference(flowEClass, FLOW__NODES);
        createEReference(flowEClass, FLOW__CONNECTIONS);

        nodeEClass = createEClass(NODE);
        createEAttribute(nodeEClass, NODE__ID);
        createEAttribute(nodeEClass, NODE__TYPE);
        createEReference(nodeEClass, NODE__PORTS);

        portEClass = createEClass(PORT);
        createEAttribute(portEClass, PORT__NAME);
        createEReference(portEClass, PORT__NODE);

        dataInPortEClass = createEClass(DATA_IN_PORT);

        dataOutPortEClass = createEClass(DATA_OUT_PORT);

        triggerInPortEClass = createEClass(TRIGGER_IN_PORT);

        triggerOutPortEClass = createEClass(TRIGGER_OUT_PORT);

        connectionEClass = createEClass(CONNECTION);

        dataConnectionEClass = createEClass(DATA_CONNECTION);
        createEReference(dataConnectionEClass, DATA_CONNECTION__IN);
        createEReference(dataConnectionEClass, DATA_CONNECTION__OUT);

        triggerConnectionEClass = createEClass(TRIGGER_CONNECTION);
        createEReference(triggerConnectionEClass, TRIGGER_CONNECTION__IN);
        createEReference(triggerConnectionEClass, TRIGGER_CONNECTION__OUT);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        dataInPortEClass.getESuperTypes().add(this.getPort());
        dataOutPortEClass.getESuperTypes().add(this.getPort());
        triggerInPortEClass.getESuperTypes().add(this.getPort());
        triggerOutPortEClass.getESuperTypes().add(this.getPort());
        dataConnectionEClass.getESuperTypes().add(this.getConnection());
        triggerConnectionEClass.getESuperTypes().add(this.getConnection());

        // Initialize classes, features, and operations; add parameters
        initEClass(flowEClass, Flow.class, "Flow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFlow_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Flow.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getFlow_Connections(), this.getConnection(), null, "connections", null, 0, -1, Flow.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNode_Id(), ecorePackage.getEString(), "id", null, 1, 1, Node.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNode_Type(), ecorePackage.getEString(), "type", null, 1, 1, Node.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNode_Ports(), this.getPort(), this.getPort_Node(), "ports", null, 0, -1, Node.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPort_Name(), ecorePackage.getEString(), "name", null, 1, 1, Port.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPort_Node(), this.getNode(), this.getNode_Ports(), "node", null, 1, 1, Port.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataInPortEClass, DataInPort.class, "DataInPort", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(dataOutPortEClass, DataOutPort.class, "DataOutPort", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(triggerInPortEClass, TriggerInPort.class, "TriggerInPort", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(triggerOutPortEClass, TriggerOutPort.class, "TriggerOutPort", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(connectionEClass, Connection.class, "Connection", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(dataConnectionEClass, DataConnection.class, "DataConnection", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataConnection_In(), this.getDataInPort(), null, "in", null, 1, 1, DataConnection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataConnection_Out(), this.getDataOutPort(), null, "out", null, 1, 1, DataConnection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(triggerConnectionEClass, TriggerConnection.class, "TriggerConnection", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTriggerConnection_In(), this.getTriggerInPort(), null, "in", null, 1, 1,
                TriggerConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTriggerConnection_Out(), this.getTriggerOutPort(), null, "out", null, 1, 1,
                TriggerConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //FlowPackageImpl

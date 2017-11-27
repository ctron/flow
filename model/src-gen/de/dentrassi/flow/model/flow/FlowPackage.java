/**
 */
package de.dentrassi.flow.model.flow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.dentrassi.flow.model.flow.FlowFactory
 * @model kind="package"
 * @generated
 */
public interface FlowPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "flow";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "uri:flow";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "flow";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FlowPackage eINSTANCE = de.dentrassi.flow.model.flow.impl.FlowPackageImpl.init();

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.FlowImpl <em>Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.FlowImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getFlow()
     * @generated
     */
    int FLOW = 0;

    /**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW__NODES = 0;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW__CONNECTIONS = 1;

    /**
     * The number of structural features of the '<em>Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOW_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.NodeImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getNode()
     * @generated
     */
    int NODE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__ID = 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__TYPE = 1;

    /**
     * The feature id for the '<em><b>Ports</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__PORTS = 2;

    /**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.PortImpl <em>Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.PortImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getPort()
     * @generated
     */
    int PORT = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PORT__NAME = 0;

    /**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PORT__NODE = 1;

    /**
     * The number of structural features of the '<em>Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PORT_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PORT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.DataInPortImpl <em>Data In Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.DataInPortImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getDataInPort()
     * @generated
     */
    int DATA_IN_PORT = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_IN_PORT__NAME = PORT__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_IN_PORT__NODE = PORT__NODE;

    /**
     * The number of structural features of the '<em>Data In Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_IN_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Data In Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_IN_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.DataOutPortImpl <em>Data Out Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.DataOutPortImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getDataOutPort()
     * @generated
     */
    int DATA_OUT_PORT = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_OUT_PORT__NAME = PORT__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_OUT_PORT__NODE = PORT__NODE;

    /**
     * The number of structural features of the '<em>Data Out Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_OUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Data Out Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_OUT_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.TriggerInPortImpl <em>Trigger In Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.TriggerInPortImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getTriggerInPort()
     * @generated
     */
    int TRIGGER_IN_PORT = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_IN_PORT__NAME = PORT__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_IN_PORT__NODE = PORT__NODE;

    /**
     * The number of structural features of the '<em>Trigger In Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_IN_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Trigger In Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_IN_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.TriggerOutPortImpl <em>Trigger Out Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.TriggerOutPortImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getTriggerOutPort()
     * @generated
     */
    int TRIGGER_OUT_PORT = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_OUT_PORT__NAME = PORT__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_OUT_PORT__NODE = PORT__NODE;

    /**
     * The number of structural features of the '<em>Trigger Out Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_OUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Trigger Out Port</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_OUT_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.ConnectionImpl <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.ConnectionImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getConnection()
     * @generated
     */
    int CONNECTION = 7;

    /**
     * The number of structural features of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.DataConnectionImpl <em>Data Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.DataConnectionImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getDataConnection()
     * @generated
     */
    int DATA_CONNECTION = 8;

    /**
     * The feature id for the '<em><b>In</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_CONNECTION__IN = CONNECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Out</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_CONNECTION__OUT = CONNECTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Data Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Data Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_CONNECTION_OPERATION_COUNT = CONNECTION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.dentrassi.flow.model.flow.impl.TriggerConnectionImpl <em>Trigger Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dentrassi.flow.model.flow.impl.TriggerConnectionImpl
     * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getTriggerConnection()
     * @generated
     */
    int TRIGGER_CONNECTION = 9;

    /**
     * The feature id for the '<em><b>In</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_CONNECTION__IN = CONNECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Out</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_CONNECTION__OUT = CONNECTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Trigger Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Trigger Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_CONNECTION_OPERATION_COUNT = CONNECTION_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.Flow <em>Flow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Flow</em>'.
     * @see de.dentrassi.flow.model.flow.Flow
     * @generated
     */
    EClass getFlow();

    /**
     * Returns the meta object for the containment reference list '{@link de.dentrassi.flow.model.flow.Flow#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nodes</em>'.
     * @see de.dentrassi.flow.model.flow.Flow#getNodes()
     * @see #getFlow()
     * @generated
     */
    EReference getFlow_Nodes();

    /**
     * Returns the meta object for the containment reference list '{@link de.dentrassi.flow.model.flow.Flow#getConnections <em>Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connections</em>'.
     * @see de.dentrassi.flow.model.flow.Flow#getConnections()
     * @see #getFlow()
     * @generated
     */
    EReference getFlow_Connections();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node</em>'.
     * @see de.dentrassi.flow.model.flow.Node
     * @generated
     */
    EClass getNode();

    /**
     * Returns the meta object for the attribute '{@link de.dentrassi.flow.model.flow.Node#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.dentrassi.flow.model.flow.Node#getId()
     * @see #getNode()
     * @generated
     */
    EAttribute getNode_Id();

    /**
     * Returns the meta object for the attribute '{@link de.dentrassi.flow.model.flow.Node#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see de.dentrassi.flow.model.flow.Node#getType()
     * @see #getNode()
     * @generated
     */
    EAttribute getNode_Type();

    /**
     * Returns the meta object for the reference list '{@link de.dentrassi.flow.model.flow.Node#getPorts <em>Ports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Ports</em>'.
     * @see de.dentrassi.flow.model.flow.Node#getPorts()
     * @see #getNode()
     * @generated
     */
    EReference getNode_Ports();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.Port <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Port</em>'.
     * @see de.dentrassi.flow.model.flow.Port
     * @generated
     */
    EClass getPort();

    /**
     * Returns the meta object for the attribute '{@link de.dentrassi.flow.model.flow.Port#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.dentrassi.flow.model.flow.Port#getName()
     * @see #getPort()
     * @generated
     */
    EAttribute getPort_Name();

    /**
     * Returns the meta object for the reference '{@link de.dentrassi.flow.model.flow.Port#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Node</em>'.
     * @see de.dentrassi.flow.model.flow.Port#getNode()
     * @see #getPort()
     * @generated
     */
    EReference getPort_Node();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.DataInPort <em>Data In Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data In Port</em>'.
     * @see de.dentrassi.flow.model.flow.DataInPort
     * @generated
     */
    EClass getDataInPort();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.DataOutPort <em>Data Out Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Out Port</em>'.
     * @see de.dentrassi.flow.model.flow.DataOutPort
     * @generated
     */
    EClass getDataOutPort();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.TriggerInPort <em>Trigger In Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger In Port</em>'.
     * @see de.dentrassi.flow.model.flow.TriggerInPort
     * @generated
     */
    EClass getTriggerInPort();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.TriggerOutPort <em>Trigger Out Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger Out Port</em>'.
     * @see de.dentrassi.flow.model.flow.TriggerOutPort
     * @generated
     */
    EClass getTriggerOutPort();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connection</em>'.
     * @see de.dentrassi.flow.model.flow.Connection
     * @generated
     */
    EClass getConnection();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.DataConnection <em>Data Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Connection</em>'.
     * @see de.dentrassi.flow.model.flow.DataConnection
     * @generated
     */
    EClass getDataConnection();

    /**
     * Returns the meta object for the reference '{@link de.dentrassi.flow.model.flow.DataConnection#getIn <em>In</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>In</em>'.
     * @see de.dentrassi.flow.model.flow.DataConnection#getIn()
     * @see #getDataConnection()
     * @generated
     */
    EReference getDataConnection_In();

    /**
     * Returns the meta object for the reference '{@link de.dentrassi.flow.model.flow.DataConnection#getOut <em>Out</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Out</em>'.
     * @see de.dentrassi.flow.model.flow.DataConnection#getOut()
     * @see #getDataConnection()
     * @generated
     */
    EReference getDataConnection_Out();

    /**
     * Returns the meta object for class '{@link de.dentrassi.flow.model.flow.TriggerConnection <em>Trigger Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger Connection</em>'.
     * @see de.dentrassi.flow.model.flow.TriggerConnection
     * @generated
     */
    EClass getTriggerConnection();

    /**
     * Returns the meta object for the reference '{@link de.dentrassi.flow.model.flow.TriggerConnection#getIn <em>In</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>In</em>'.
     * @see de.dentrassi.flow.model.flow.TriggerConnection#getIn()
     * @see #getTriggerConnection()
     * @generated
     */
    EReference getTriggerConnection_In();

    /**
     * Returns the meta object for the reference '{@link de.dentrassi.flow.model.flow.TriggerConnection#getOut <em>Out</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Out</em>'.
     * @see de.dentrassi.flow.model.flow.TriggerConnection#getOut()
     * @see #getTriggerConnection()
     * @generated
     */
    EReference getTriggerConnection_Out();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    FlowFactory getFlowFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.FlowImpl <em>Flow</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.FlowImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getFlow()
         * @generated
         */
        EClass FLOW = eINSTANCE.getFlow();

        /**
         * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FLOW__NODES = eINSTANCE.getFlow_Nodes();

        /**
         * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FLOW__CONNECTIONS = eINSTANCE.getFlow_Connections();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.NodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.NodeImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getNode()
         * @generated
         */
        EClass NODE = eINSTANCE.getNode();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NODE__ID = eINSTANCE.getNode_Id();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NODE__TYPE = eINSTANCE.getNode_Type();

        /**
         * The meta object literal for the '<em><b>Ports</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE__PORTS = eINSTANCE.getNode_Ports();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.PortImpl <em>Port</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.PortImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getPort()
         * @generated
         */
        EClass PORT = eINSTANCE.getPort();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PORT__NAME = eINSTANCE.getPort_Name();

        /**
         * The meta object literal for the '<em><b>Node</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PORT__NODE = eINSTANCE.getPort_Node();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.DataInPortImpl <em>Data In Port</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.DataInPortImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getDataInPort()
         * @generated
         */
        EClass DATA_IN_PORT = eINSTANCE.getDataInPort();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.DataOutPortImpl <em>Data Out Port</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.DataOutPortImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getDataOutPort()
         * @generated
         */
        EClass DATA_OUT_PORT = eINSTANCE.getDataOutPort();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.TriggerInPortImpl <em>Trigger In Port</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.TriggerInPortImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getTriggerInPort()
         * @generated
         */
        EClass TRIGGER_IN_PORT = eINSTANCE.getTriggerInPort();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.TriggerOutPortImpl <em>Trigger Out Port</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.TriggerOutPortImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getTriggerOutPort()
         * @generated
         */
        EClass TRIGGER_OUT_PORT = eINSTANCE.getTriggerOutPort();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.ConnectionImpl <em>Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.ConnectionImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getConnection()
         * @generated
         */
        EClass CONNECTION = eINSTANCE.getConnection();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.DataConnectionImpl <em>Data Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.DataConnectionImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getDataConnection()
         * @generated
         */
        EClass DATA_CONNECTION = eINSTANCE.getDataConnection();

        /**
         * The meta object literal for the '<em><b>In</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_CONNECTION__IN = eINSTANCE.getDataConnection_In();

        /**
         * The meta object literal for the '<em><b>Out</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_CONNECTION__OUT = eINSTANCE.getDataConnection_Out();

        /**
         * The meta object literal for the '{@link de.dentrassi.flow.model.flow.impl.TriggerConnectionImpl <em>Trigger Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.dentrassi.flow.model.flow.impl.TriggerConnectionImpl
         * @see de.dentrassi.flow.model.flow.impl.FlowPackageImpl#getTriggerConnection()
         * @generated
         */
        EClass TRIGGER_CONNECTION = eINSTANCE.getTriggerConnection();

        /**
         * The meta object literal for the '<em><b>In</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRIGGER_CONNECTION__IN = eINSTANCE.getTriggerConnection_In();

        /**
         * The meta object literal for the '<em><b>Out</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRIGGER_CONNECTION__OUT = eINSTANCE.getTriggerConnection_Out();

    }

} //FlowPackage

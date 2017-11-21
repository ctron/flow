/*******************************************************************************
 * Copyright (c) 2017 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package de.dentrassi.flow.component.kapua;

import org.eclipse.kapua.client.gateway.Client;
import org.eclipse.kapua.client.gateway.Credentials;
import org.eclipse.kapua.client.gateway.Transport.ListenerHandle;
import org.eclipse.kapua.client.gateway.mqtt.fuse.FuseChannel;
import org.eclipse.kapua.client.gateway.mqtt.fuse.FuseChannel.Builder;
import org.eclipse.kapua.client.gateway.profile.kura.KuraMqttProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.spi.component.AnnotatedComponent;
import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.DataOut;
import de.dentrassi.flow.spi.component.TriggerIn;
import de.dentrassi.flow.spi.component.TriggerOut;

public class KapuaClient extends AnnotatedComponent {

    private static final Logger logger = LoggerFactory.getLogger(KapuaClient.class);

    private String accountName;
    private String clientId;
    private String brokerUrl;
    private String username;
    private String password;
    private Client client;
    private ListenerHandle listenerHandle;
    private boolean connected;
    private Runnable connectionEstablished;
    private Runnable connectionLost;
    private Runnable clientCreated;
    private Runnable clientDisposed;

    @DataIn
    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }

    @DataIn
    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    @DataIn
    public void setBrokerUrl(final String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    @DataIn
    public void setUsername(final String username) {
        this.username = username;
    }

    @DataIn
    public void setPassword(final String password) {
        this.password = password;
    }

    @DataOut
    public Client getClient() {
        return this.client;
    }

    @TriggerOut
    public void setConnectionEstablished(final Runnable connectionEstablished) {
        this.connectionEstablished = connectionEstablished;
    }

    @TriggerOut
    public void setConnectionLost(final Runnable connectionLost) {
        this.connectionLost = connectionLost;
    }

    @TriggerOut
    public void setClientCreated(final Runnable clientCreated) {
        this.clientCreated = clientCreated;
    }

    @TriggerOut
    public void setClientDisposed(final Runnable clientDisposed) {
        this.clientDisposed = clientDisposed;
    }

    @DataOut
    public boolean isConnected() {
        return this.connected;
    }

    @TriggerIn
    public void connect() throws Exception {

        logger.info("Connecting client - broker: {}, clientId: {}", this.brokerUrl, this.clientId);

        final KuraMqttProfile<Builder> builder = KuraMqttProfile.newProfile(FuseChannel.Builder::new)
                .accountName(this.accountName)
                .clientId(this.clientId)
                .brokerUrl(this.brokerUrl);

        if (this.username != null && this.password != null) {
            builder.credentials(Credentials.userAndPassword(this.username, this.password));
        }

        this.client = builder.build();
        this.listenerHandle = this.client.transport().listen(connected -> {
            runOnContext(() -> {
                handleConnectionStateChange(connected);
            });
        });

        logger.info("Created client - broker: {}, clientId: {}", this.brokerUrl, this.clientId);

        this.clientCreated.run();
    }

    @TriggerIn
    public void disconnect() throws Exception {
        this.clientDisposed.run();

        if (this.listenerHandle != null) {
            this.listenerHandle.close();
            this.listenerHandle = null;
        }
        if (this.client != null) {
            this.client.close();
            this.client = null;
        }
    }

    private void handleConnectionStateChange(final boolean connected) {
        logger.info("Connection state changed: {}", connected);

        this.connected = connected;
        if (connected) {
            this.connectionEstablished.run();
        } else {
            this.connectionLost.run();
        }
    }

}

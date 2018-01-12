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
package de.dentrassi.flow.component.mqtt;

import java.time.Duration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.ComponentContext.SharedResource;
import de.dentrassi.flow.spi.component.AnnotatedComponent;
import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.DataOut;
import de.dentrassi.flow.spi.component.EventContext;
import de.dentrassi.flow.spi.component.TriggerIn;
import de.dentrassi.flow.spi.component.TriggerPortOut;
import io.vertx.core.Vertx;
import io.vertx.mqtt.MqttClientOptions;

public class MqttClient extends AnnotatedComponent {

    private static final Logger logger = LoggerFactory.getLogger(MqttClient.class);

    private final TriggerPortOut connectionEstablished;
    private final TriggerPortOut connectionLost;

    private String host;
    private int port;
    private String clientId;
    private String username;
    private String password;

    private SharedResource<Vertx> vertx;
    private de.dentrassi.flow.component.mqtt.internal.io.vertx.mqtt.MqttClient client;

    private boolean started;
    private boolean connected;

    private final long nextSleepMultiplier = 2;
    private final Duration nextSleepMax = Duration.ofMinutes(1);

    private volatile Duration nextSleep = Duration.ZERO;

    public MqttClient() {
        super();

        this.connectionEstablished = registerTriggerOut("connectionEstablished");
        this.connectionLost = registerTriggerOut("connectionLost");
    }

    @Override
    public void start(final Map<String, String> initializers, final ComponentContext context,
            final EventContext event) {
        super.start(initializers, context, event);
        this.vertx = context.createSharedResource(MqttClient.class, "vertx", Vertx.class, () -> Vertx.vertx(),
                Vertx::close);
        this.started = true;
    }

    @Override
    public void stop() {
        this.started = false;
        disconnect();
        this.vertx.close();
        super.stop();
    }

    @DataOut
    public boolean isConnected() {
        return this.connected;
    }

    @TriggerIn
    public void connect() {
        final MqttClientOptions options = new MqttClientOptions();

        if (this.clientId != null) {
            options.setAutoGeneratedClientId(false);
            options.setClientId(this.clientId);
        } else {
            options.setAutoGeneratedClientId(true);
        }

        options.setAutoKeepAlive(true);
        options.setUsername(this.username);
        options.setPassword(this.password);

        getInitializer("trustAll", Boolean.class)
                .ifPresent(options::setTrustAll);

        getInitializer("ssl", Boolean.class)
                .ifPresent(options::setSsl);

        this.client = de.dentrassi.flow.component.mqtt.internal.io.vertx.mqtt.MqttClient
                .create(this.vertx.get(), options)
                .closeHandler(v -> {
                    runOnContext(this::connectionLost);
                });
        performConnect();
    }

    private void performConnect() {
        logger.info("Trigger connect");

        if (!this.started) {
            logger.info("Cancel connect attempt. We are stopped.");
            return;
        }

        final Duration sleep = nextSleep();
        logger.info("Reconnect delay: {}", sleep);

        if (!sleep.isZero()) {
            this.vertx.get().setTimer(sleep.toMillis(), timer -> {
                doConnect();
            });
        } else {
            doConnect();
        }
    }

    private void doConnect() {
        this.client.connect(this.port, this.host, this.host, connected -> {
            if (connected.succeeded()) {
                runOnContext(this::connectionEstablished);
            } else {
                logger.warn("Failed to connect", connected.cause());
                runOnContext(this::connectionLost);
            }
        });
    }

    private Duration nextSleep() {
        final Duration result = this.nextSleep;

        Duration next = this.nextSleep;

        // start incrementing

        if (next.isZero()) {
            next = Duration.ofMillis(100);
        } else {
            next = next.multipliedBy(this.nextSleepMultiplier);
        }

        // check if over max

        if (next.compareTo(this.nextSleepMax) <= 0) {
            this.nextSleep = next;
        } else {
            this.nextSleep = this.nextSleepMax;
        }

        return result;
    }

    @TriggerIn
    public void disconnect() {
        this.client.disconnect();
    }

    private void connectionLost() {
        logger.info("Connection lost - previousState: {}", this.connected);
        if (this.connected) {
            this.connected = false;
            this.connectionLost.execute();
        } else {
            logger.info("Receive lost event when already disconnected");
        }

        performConnect();
    }

    private void connectionEstablished() {
        logger.info("Connection established - previousState: {}", this.connected);
        if (!this.connected) {
            this.nextSleep = Duration.ZERO;
            this.connected = true;
            this.connectionEstablished.execute();
        } else {
            logger.error("Receive established event when already connected");
        }
    }

    @DataIn
    public void setHost(final String host) {
        this.host = host;
    }

    @DataIn
    public void setPort(final Integer port) {
        this.port = port == null ? 1883 : port;
    }

    @DataIn
    public void setClientId(final String clientId) {
        this.clientId = clientId;
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
    public de.dentrassi.flow.component.mqtt.internal.io.vertx.mqtt.MqttClient getClient() {
        return this.client;
    }

}

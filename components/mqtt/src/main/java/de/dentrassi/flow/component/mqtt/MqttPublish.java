/*******************************************************************************
 * Copyright (c) 2017, 2018 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package de.dentrassi.flow.component.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.spi.component.AnnotatedComponent;
import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.SimpleSingleDataPortIn;
import de.dentrassi.flow.spi.component.TriggerIn;
import de.dentrassi.flow.spi.component.ValueResult;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.vertx.core.buffer.Buffer;
import io.vertx.mqtt.MqttClient;

public class MqttPublish extends AnnotatedComponent {

    private static final Logger logger = LoggerFactory.getLogger(MqttPublish.class);

    private MqttClient client;
    private String topic;

    private final SimpleSingleDataPortIn payload;

    private MqttQoS qos = MqttQoS.AT_MOST_ONCE;

    public MqttPublish() {
        this.payload = registerDataIn("payload", new SimpleSingleDataPortIn());
    }

    @TriggerIn
    public void publish() {
        if (this.client == null) {
            logger.debug("No client");
            return;
        }

        final ValueResult value = this.payload.getValue();
        if (value == null) {
            logger.debug("No payload data found");
            return;
        }

        boolean published = false;

        for (final Object v : value.getValues()) {

            if (v instanceof String) {
                publish(Buffer.buffer((String) v));
                published = true;
            } else if (v instanceof byte[]) {
                publish(Buffer.buffer((byte[]) v));
                published = true;
            }

            if (published) {
                break;
            }
        }

        if (!published) {
            throw new IllegalStateException("Unable to accept payload type - possible choices: " + value);
        }
    }

    private void publish(final Buffer payload) {
        this.client.publish(this.topic, payload, this.qos, false, false);
    }

    @DataIn
    public void setQos(final Integer qos) {
        if (qos == null) {
            setQos(MqttQoS.AT_MOST_ONCE);
            return;
        }

        switch (qos) {
        case 0:
            setQos(MqttQoS.AT_MOST_ONCE);
            return;
        case 1:
            setQos(MqttQoS.AT_LEAST_ONCE);
            return;
        case 2:
            setQos(MqttQoS.EXACTLY_ONCE);
            return;
        }
    }

    private void setQos(final MqttQoS qos) {
        this.qos = qos;
    }

    @DataIn
    public void setTopic(final String topic) {
        this.topic = topic;
    }

    @DataIn(initialize = false)
    public void setClient(final MqttClient client) {
        this.client = client;
    }

}

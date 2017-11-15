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

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.kapua.client.gateway.Application;
import org.eclipse.kapua.client.gateway.Payload;
import org.eclipse.kapua.client.gateway.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.spi.component.AnnotatedComponent;
import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.TriggerIn;

public class KapuaTopic extends AnnotatedComponent {

    private static final Logger logger = LoggerFactory.getLogger(KapuaTopic.class);

    private Application application;

    private Topic topic;

    private Map<?, ?> payload;

    @DataIn(initialize = false)
    public void setApplication(final Application application) {
        this.application = application;
    }

    @DataIn
    public void setTopic(final String topic) {
        this.topic = Topic.split(topic);
    }

    @DataIn
    public void setPayload(final Map<?, ?> payload) {
        this.payload = payload;
    }

    @TriggerIn
    public void publish() {
        if (this.payload == null) {
            return;
        }

        final Map<String, ?> payload = this.payload.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(), Entry::getValue));

        this.application.data(this.topic).send(Payload.of(payload))
                .whenComplete((v, e) -> {
                    if (e != null) {
                        logger.warn("Failed to publish", e);
                    }
                });
    }
}

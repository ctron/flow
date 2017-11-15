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

import org.eclipse.kapua.client.gateway.Application;
import org.eclipse.kapua.client.gateway.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.spi.component.AnnotatedComponent;
import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.DataOut;
import de.dentrassi.flow.spi.component.TriggerIn;

public class KapuaApplication extends AnnotatedComponent {

    private static final Logger logger = LoggerFactory.getLogger(KapuaApplication.class);

    private Client client;

    private String applicationId;

    private Application application;

    @DataIn(initialize = false)
    public void setClient(final Client client) {
        this.client = client;
    }

    @DataOut
    public Application getApplication() {
        return this.application;
    }

    @DataIn
    public void setApplicationId(final String applicationId) {
        this.applicationId = applicationId;
    }

    @TriggerIn
    public void create() {
        logger.info("Create application: {}", this.applicationId);
        this.application = this.client.buildApplication(this.applicationId).build();
    }

    @TriggerIn
    public void dispose() throws Exception {
        logger.info("Dispose application: {}", this.applicationId);

        if (this.application != null) {
            try {
                this.application.close();
            } finally {
                this.application = null;
            }
        }
    }
}

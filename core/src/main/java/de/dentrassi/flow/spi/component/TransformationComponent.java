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
package de.dentrassi.flow.spi.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TransformationComponent extends AbstractComponent {

    private static final Logger logger = LoggerFactory.getLogger(TransformationComponent.class);

    private final SimpleSingleDataPortIn input;

    protected TransformationComponent() {
        this.input = registerDataIn("input", new SimpleSingleDataPortIn());
        registerDataOut("output", this::process);
    }

    private ValueResult process(final ValueRequest request) {

        // update source value

        this.input.update();

        // process error

        final ValueResult value = this.input.getValue();
        if (value.isError()) {
            logger.debug("Source is errored");
            return value;
        }

        // trigger conversion

        try {
            final ValueResult result = convert(request, value);
            logger.debug("Transformed[{}] - {} / {} = {}", getClass(), request, value, result);
            return result;
        } catch (final Exception e) {
            logger.info("Failed to transform value", e);
            return ValueResult.ofError(e);
        }
    }

    public abstract ValueResult convert(ValueRequest request, ValueResult input) throws Exception;

}

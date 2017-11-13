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
package de.dentrassi.flow.component;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.spi.DataPlugIn;
import de.dentrassi.flow.spi.component.AbstractComponent;

public class MapBuilder extends AbstractComponent {

    private static final Logger logger = LoggerFactory.getLogger(MapBuilder.class);

    private final Map<String, DataPlugIn> sources = new HashMap<>();

    public MapBuilder() {
        registerDataOut("map", this::getMap);
    }

    protected Map<String, ?> getMap() {
        try {
            final Map<String, Object> result = new HashMap<>(this.sources.size());

            for (final Map.Entry<String, DataPlugIn> entry : this.sources.entrySet()) {
                final Object v = entry.getValue().get().getValueAs(Object.class);
                result.put(entry.getKey(), v);
            }

            logger.debug("Map: {}", result);

            return result;
        } catch (final Exception e) {
            throw new RuntimeException("Failed to build map", e);
        }

    }

    @Override
    public void connectDataIn(final String portName, final DataPlugIn plug) {
        this.sources.put(portName, plug);
    }

}

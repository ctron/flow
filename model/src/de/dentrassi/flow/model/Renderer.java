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
package de.dentrassi.flow.model;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.newBufferedWriter;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;

import de.dentrassi.flow.model.flow.Flow;

public interface Renderer {

    public void render(Flow flow, Writer writer) throws IOException;

    public default void render(final Flow flow, final Path file) throws IOException {
        try (final Writer writer = newBufferedWriter(file, UTF_8, CREATE, TRUNCATE_EXISTING)) {
            render(flow, writer);
        }
    }

    public default void render(final Flow flow, final OutputStream out) throws IOException {
        render(flow, new OutputStreamWriter(out, UTF_8));
    }

}

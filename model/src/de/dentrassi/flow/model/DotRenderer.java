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

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DotRenderer implements Renderer {

    private DotRenderer() {
    }

    @Override
    public void render(final Flow flow, final Writer writer) {

        final PrintWriter out = new PrintWriter(writer);

        out.println("digraph flow {");

        out.println("graph [rankdir=\"LR\"];");
        out.println("node [shape=record];");
        out.println("edge [minlen=2];");

        for (final Node n : flow.getNodes()) {

            final Set<String> ins = new TreeSet<>();
            final Set<String> outs = new TreeSet<>();

            for (final Port p : n.getPorts()) {

                if (p instanceof DataInPort || p instanceof TriggerInPort) {
                    ins.add(String.format("<%1$s> %1$s", p.getName()));
                } else if (p instanceof DataOutPort || p instanceof TriggerOutPort) {
                    outs.add(String.format("<%1$s> %1$s", p.getName()));
                }

            }

            final String inGroup = "{" + String.join("|", ins) + "}";
            final String outGroup = "{" + String.join("|", outs) + "}";

            String type = n.getType();
            final String toks[] = type.split("\\.");
            if (toks.length > 1) {
                final String sn = toks[toks.length - 1];
                type = sn + "\n"
                        + Arrays.stream(toks, 0, toks.length - 1).collect(Collectors.joining("."));
            }

            final String label = String.format("{ %s | %s | %s }", inGroup, type, outGroup);

            out.format("\"%s\"[shape=record,label=\"%s\"]%n", n.getId(),
                    label);
        }

        out.println();

        for (final Connection c : flow.getConnections()) {
            if (c instanceof DataConnection) {

                final DataOutPort outPort = ((DataConnection) c).getOut();
                final DataInPort inPort = ((DataConnection) c).getIn();

                final Map<String, String> attributes = new HashMap<>();
                attributes.put("arrowhead", "none");
                attributes.put("arrowtail", "inv");
                attributes.put("dir", "both");
                attributes.put("color", "blue");

                // edge(out, outPort.getNode().getId(), inPort.getNode().getId(), attributes);
                edge(out, outPort, inPort, attributes);

            } else if (c instanceof TriggerConnection) {

                final TriggerOutPort outPort = ((TriggerConnection) c).getOut();
                final TriggerInPort inPort = ((TriggerConnection) c).getIn();

                final Map<String, String> attributes = new HashMap<>();
                attributes.put("color", "red");

                edge(out, outPort, inPort, attributes);

            }
        }

        out.println("}");

    }

    public static DotRenderer newRenderer() {
        return new DotRenderer();
    }

    private static void edge(final PrintWriter writer, final Port out, final Port in,
            final Map<String, String> attributes) {

        edge(writer,
                String.format("\"%s\":\"%s\":e", out.getNode().getId(), out.getName()),
                String.format("\"%s\":\"%s\":w", in.getNode().getId(), in.getName()),
                attributes);

    }

    private static void edge(final PrintWriter writer, final String out, final String in,
            final Map<String, String> attributes) {

        writer.append(out);

        writer.append(" -> ");

        writer.append(in);

        final String r = attributes.entrySet().stream().map(entry -> {

            final String key = entry.getKey();
            final String value = entry.getValue();

            return key + "=\"" + value + "\"";
        }).collect(Collectors.joining(",", "[", "]"));

        writer.append(r);

        writer.println();

    }

}

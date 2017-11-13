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
package de.dentrassi.flow.examples;

import static de.dentrassi.flow.Port.port;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import de.dentrassi.flow.ComponentInstance;
import de.dentrassi.flow.Flow;
import de.dentrassi.flow.spi.type.ClassLoaderComponentFactory;
import de.dentrassi.flow.spi.type.ComponentFactory;

public class Application1 {
    public static void main(final String[] args) throws Exception {

        final ComponentFactory componentFactory = new ClassLoaderComponentFactory(
                Thread.currentThread().getContextClassLoader());

        try (final Flow flow = new Flow(componentFactory)) {

            flow.modify(context -> {

                final ComponentInstance a = context.createComponent("de.dentrassi.flow.examples.Foo", map(map -> {
                    map.put("messageIn", "Foo");
                }));

                final ComponentInstance b = context.createComponent("de.dentrassi.flow.examples.Bar", map(map -> {
                }));

                final ComponentInstance c = context.createComponent("de.dentrassi.flow.component.ConsoleOutput",
                        map(map -> {
                            map.put("format", "Hello: %s%n");
                        }));

                context.connectTrigger(port(context, "init"), port(a, "execute"));

                context.connectTrigger(port(a, "changed"), port(b, "output"));
                context.connectData(port(a, "messageOut"), port(b, "message"));

                context.connectTrigger(port(a, "changed"), port(c, "execute"));
                context.connectData(port(a, "messageOut"), port(c, "value"));

                final ComponentInstance stringConstant = context
                        .createComponent("de.dentrassi.flow.component.StringConstant", map(map -> {
                            map.put("value", "042");
                        }));

                final ComponentInstance s2l = context.createComponent("de.dentrassi.flow.component.StringToLong", null);

                final ComponentInstance d = context.createComponent("de.dentrassi.flow.component.ConsoleOutput", null);

                context.connectTrigger(port(context, "init"), port(d, "execute"));
                context.connectData(port(stringConstant, "value"), port(s2l, "input"));
                context.connectData(port(s2l, "output"), port(d, "value"));

            });

            flow.start();
            flow.stop();
        }
    }

    public static <K, V> Map<K, V> map(final Consumer<Map<K, V>> initializer) {
        final Map<K, V> result = new HashMap<>();
        initializer.accept(result);
        return result;
    }
}

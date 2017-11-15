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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AnnotatedComponent extends AbstractComponent {

    private static final Logger logger = LoggerFactory.getLogger(AnnotatedComponent.class);

    protected AnnotatedComponent() {
        register();
    }

    private void register() {
        for (final Method method : getClass().getMethods()) {

            final DataIn dataIn = method.getAnnotation(DataIn.class);
            if (dataIn != null) {
                registerDataIn(method, dataIn);
            }

            final DataOut dataOut = method.getAnnotation(DataOut.class);
            if (dataOut != null) {
                registerDataOut(method, dataOut);
            }

            final TriggerIn triggerIn = method.getAnnotation(TriggerIn.class);
            if (triggerIn != null) {
                registerTriggerIn(method, triggerIn);
            }

            final TriggerOut triggerOut = method.getAnnotation(TriggerOut.class);
            if (triggerOut != null) {
                registerTriggerOut(method, triggerOut);
            }

        }
    }

    private void registerDataIn(final Method method, final DataIn dataIn) {
        if (method.getParameterCount() != 1) {
            throw new IllegalStateException(String.format(
                    "Method '%s' is annotated with @%s, but has %s declared parameters. It must have exactly one.",
                    method, DataIn.class.getSimpleName(), method.getParameterCount()));
        }

        String name = method.getName();
        if (name.startsWith("set") && name.length() > 3) {
            name = name.substring(3);
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
        }

        final String finalName = name;

        final Supplier<Object> initializer;

        if (dataIn.initialize()) {
            initializer = () -> getInitializer(finalName);
        } else {
            initializer = () -> null;
        }

        final Class<?> type = method.getParameterTypes()[0];

        registerDataIn(finalName, initializer, value -> {

            Object targetValue = null;

            try {
                targetValue = value.getValueAs(type);
            } catch (final Exception e) {
                logger.info("Failed to convert to target value", e);
            }

            // a type mismatch will result in a null value

            try {
                method.invoke(AnnotatedComponent.this, targetValue);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void registerDataOut(final Method method, final DataOut dataOut) {
        if (method.getParameterCount() != 0) {
            throw new IllegalStateException(String.format(
                    "Method '%s' is annotated with @%s, but has %s declared parameters. It must have none.", method,
                    DataOut.class.getSimpleName(), method.getParameterCount()));
        }

        String name = method.getName();

        if (name.startsWith("get") && name.length() > 3) {
            name = name.substring(3);
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
        } else if (name.startsWith("is") && name.length() > 2) {
            name = name.substring(2);
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
        }

        final String finalName = name;

        registerDataOut(finalName, () -> {
            try {
                return method.invoke(AnnotatedComponent.this);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new RuntimeException("Failed to get @DataOut value through introspection", e);
            }
        });
    }

    private void registerTriggerIn(final Method method, final TriggerIn triggerIn) {
        if (method.getParameterCount() != 0) {
            throw new IllegalStateException(
                    String.format("Method '%s' is annotated with @%s, but has declared parameters.", method,
                            TriggerIn.class.getSimpleName()));
        }

        registerTriggerIn(method.getName(), () -> {
            try {
                updateAllData();
                method.invoke(AnnotatedComponent.this);
            } catch (final Exception e) {
                logger.warn("Trigger In failed", e);
                throw new RuntimeException(e);
            }
        });
    }

    private void registerTriggerOut(final Method method, final TriggerOut triggerOut) {

        if (method.getParameterCount() != 1 || method.getParameterTypes()[0].isAssignableFrom(Runtime.class)) {
            throw new IllegalStateException(
                    String.format(
                            "Method '%s' is annotated with @%s, but doesn't have exactly one argument of type %s.",
                            method, TriggerOut.class.getSimpleName(), Runnable.class.getName()));
        }

        String name = method.getName();
        if (name.startsWith("set") && name.length() > 3) {
            name = name.substring(3);
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
        }

        final TriggerPortOut trigger = registerTriggerOut(name);
        final Runnable runnable = trigger::execute;

        try {
            method.invoke(this, runnable);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException("Failed to assing trigger out runnable", e);
        }
    }

}

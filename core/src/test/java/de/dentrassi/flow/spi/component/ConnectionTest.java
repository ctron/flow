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

import static de.dentrassi.flow.spi.component.MockComponentInstance.MOCK;

import org.junit.Assert;
import org.junit.Test;

import de.dentrassi.flow.Port;
import de.dentrassi.flow.internal.FlowDataConnection;

public class ConnectionTest {

    private static final Port OUT = MOCK.port("out");
    private static final Port IN = MOCK.port("in");

    @Test
    public void test1() {
        final DataPortOut dataPortOut = new SimpleDataPortOut(SimpleDataPortOut.singleType(() -> "String"));
        final SimpleSingleDataPortIn dataPortIn = new SimpleSingleDataPortIn();

        connect(dataPortOut, dataPortIn, Object.class);
        assertConnection(dataPortIn, "String");
    }

    @Test
    public void test2() {
        final DataPortOut dataPortOut = new SimpleDataPortOut(SimpleDataPortOut.singleType(() -> 42L));
        final SimpleSingleDataPortIn dataPortIn = new SimpleSingleDataPortIn();

        connect(dataPortOut, dataPortIn, Object.class);
        assertConnection(dataPortIn, 42L);
    }

    @Test
    public void test3() {
        final DataPortOut dataPortOut = new SimpleDataPortOut(SimpleDataPortOut.singleType(() -> 42));
        final SimpleSingleDataPortIn dataPortIn = new SimpleSingleDataPortIn();

        connect(dataPortOut, dataPortIn, Object.class);
        assertConnection(dataPortIn, 42, Number.class);
    }

    @Test
    public void test4() {
        final DataPortOut dataPortOut = new SimpleDataPortOut(SimpleDataPortOut.singleType(() -> 42));
        final SimpleSingleDataPortIn dataPortIn = new SimpleSingleDataPortIn();

        connect(dataPortOut, dataPortIn, String.class);
        assertConnectionError(dataPortIn);
    }

    private static FlowDataConnection connect(final DataPortOut out, final DataPortIn in,
            final Class<?> requiredType) {
        final FlowDataConnection result = new FlowDataConnection(OUT, IN, requiredType);
        result.out().setSupplier(out);
        in.add(result.in());
        return result;
    }

    private static void assertConnectionError(final SimpleSingleDataPortIn in) {
        in.update();

        Assert.assertNotNull(in.getError());
    }

    private static void assertConnection(final SimpleSingleDataPortIn in, final Object expectedValue) {
        in.update();

        Assert.assertNull(in.getError());
        Assert.assertEquals(expectedValue, in.getValue().getValueAsOptional(expectedValue.getClass()).get());
    }

    private static <T> void assertConnection(final SimpleSingleDataPortIn in, final T expectedValue,
            final Class<T> expectedType) {
        in.update();

        Assert.assertNull(in.getError());
        Assert.assertEquals(expectedValue, in.getValue().getValueAsOptional(expectedType).get());
    }

}

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
package de.dentrassi.flow.type;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TypeConverterManagerTest {

    private DefaultTypeConverterManager manager;

    @Before
    public void setup() {
        this.manager = new DefaultTypeConverterManager();
    }

    @Test
    public void test1() {
        assertConvert("42", Long.class, 42L);
    }

    @Test
    public void test2() {
        assertConvert("42", String.class, "42");
    }

    private <T, R> void assertConvert(final T value, final Class<R> clazz, final R expected) {
        final R result = this.manager.convert(value, clazz);
        Assert.assertEquals(expected, result);
    }
}

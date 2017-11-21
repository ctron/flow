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

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

import de.dentrassi.flow.spi.component.DataIn;
import de.dentrassi.flow.spi.component.SimpleTransformationComponent;

public class StringToNumber extends SimpleTransformationComponent<String, Number> {

    private Locale locale;

    public StringToNumber() {
        super(String.class, Number.class);
    }

    @DataIn
    public void setLanguageTag(final String languageTag) {
        this.locale = this.locale != null ? Locale.forLanguageTag(languageTag) : null;
    }

    @Override
    public Number convertValue(final String input) {
        final ParsePosition parsePosition = new ParsePosition(0);

        NumberFormat format;

        if (this.locale != null) {
            format = NumberFormat.getNumberInstance(this.locale);
        } else {
            format = NumberFormat.getNumberInstance();
        }

        final Number result = format.parse(input, parsePosition);

        if (!isFullMatch()) {
            if (parsePosition.getIndex() != input.length()) {
                throw new NumberFormatException(input);
            }
        }

        return result;
    }

    private boolean isFullMatch() {
        return true; // FIXME: make configurable
    }

}

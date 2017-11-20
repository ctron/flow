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
package de.dentrassi.flow.component.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.ComponentContext;
import de.dentrassi.flow.ComponentContext.SharedResource;
import de.dentrassi.flow.spi.DataPlugOut;
import de.dentrassi.flow.spi.component.AbstractComponent;
import de.dentrassi.flow.spi.component.ValueRequest;
import de.dentrassi.flow.spi.component.ValueResult;
import io.glutamate.time.Durations;

public class CsvTimeSeriesReader extends AbstractComponent {

    private static final Logger logger = LoggerFactory.getLogger(CsvTimeSeriesReader.class);

    private SharedResource<ScheduledExecutorService> executor;

    private String file;

    private String timestampColumn;

    private CSVParser parser;

    private Iterator<CSVRecord> iterator;

    private CSVRecord record;
    private CSVRecord nextRecord;

    private TimeUnit timestampUnit;

    private ComponentContext context;

    private Long durationMultipliedBy;
    private Long durationDividedBy;

    private Instant nextUpdate;

    public CsvTimeSeriesReader() {
        registerTriggerIn("open", this::open);
        registerTriggerIn("close", this::close);

        registerDataIn("file", String.class, () -> getInitializer("file"), () -> null, this::setFile);
        registerDataIn("timestampColumn", String.class, () -> getInitializer("timestampColumn"), () -> null,
                this::setTimestampColumn);

        // TODO: Make this a mixed type port (String, TimeUnit)
        registerDataIn("timestampUnit", String.class, () -> getInitializer("timestampUnit", "MS"), () -> null,
                this::setTimestampUnit);

        registerDataIn("durationMultipliedBy", Long.class, () -> getInitializerLong("durationMultipliedBy", null),
                () -> null, this::setDurationMultipliedBy);
        registerDataIn("durationDividedBy", Long.class, () -> getInitializerLong("durationDividedBy", null), () -> null,
                this::setDurationDividedBy);

        registerDataOut("record", this::getRecord);

        registerTriggerOut("updated");
        registerTriggerOut("completed");
    }

    @Override
    public void start(final Map<String, String> initializers, final ComponentContext context) {
        super.start(initializers, context);

        this.context = context;
        this.executor = context.createSharedResource(getClass().getName(), "executor", ScheduledExecutorService.class,
                () -> Executors.newSingleThreadScheduledExecutor(), ExecutorService::shutdown);
    }

    @Override
    public void stop() {

        this.executor.close();

        super.stop();
    }

    private void setFile(final String file) {
        this.file = file;
    }

    private void setTimestampColumn(final String timestampColumn) {
        this.timestampColumn = timestampColumn;
    }

    private void setDurationMultipliedBy(final Long durationMultipliedBy) {
        this.durationMultipliedBy = durationMultipliedBy;
    }

    private void setDurationDividedBy(final Long durationDividedBy) {
        this.durationDividedBy = durationDividedBy;
    }

    private void setTimestampUnit(final String timestampUnit) {
        if (timestampUnit == null || timestampUnit.isEmpty()) {
            this.timestampUnit = TimeUnit.SECONDS;
        } else {
            switch (timestampUnit.toUpperCase()) {

            case "MICRO": //$FALL-THROUGH$
            case "MICROS":
                this.timestampUnit = TimeUnit.MICROSECONDS;
                break;

            case "MS": //$FALL-THROUGH$
            case "MILLIS":
                this.timestampUnit = TimeUnit.MILLISECONDS;
                break;

            case "S": //$FALL-THROUGH$
            case "SEC":
                this.timestampUnit = TimeUnit.SECONDS;
                break;

            case "MIN":
                this.timestampUnit = TimeUnit.MINUTES;
                break;

            default:
                this.timestampUnit = TimeUnit.valueOf(timestampUnit.toUpperCase());
                break;
            }
        }

    }

    public void open() {

        logger.info("Opening CSV");

        updateAllData();

        if (this.file == null) {
            logger.debug("No file configured");
            return;
        }

        final Path path = Paths.get(this.file);
        if (!Files.isReadable(path)) {
            logger.info("File {} is not readable", this.file);
            return;
        }

        try {
            this.parser = CSVParser.parse(path, StandardCharsets.UTF_8, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            this.iterator = this.parser.iterator();

            if (this.iterator.hasNext()) {
                this.nextRecord = this.iterator.next();
                readNext();
            } else {
                fireEndOfFile();
            }

        } catch (final IOException e) {
            logger.info("Failed to open reader", e);
        }
    }

    public void close() {
        this.iterator = null;
        if (this.parser != null) {
            try {
                this.parser.close();
            } catch (final IOException e) {
                logger.info("Failed to close reader", e);
            }
            this.parser = null;
        }
    }

    protected void readNext() {
        if (this.parser == null) {
            return;
        }

        setCurrentRecord(this.nextRecord);
        fireUpdated();

        if (!this.iterator.hasNext()) {
            this.nextRecord = null;
            logger.info("Reached end of input");
            fireEndOfFile();
            return;
        }

        this.nextRecord = this.iterator.next();

        Duration duration;
        try {
            final Instant now = Instant.ofEpochMilli(fromRecord(this.record));
            final Instant next = Instant.ofEpochMilli(fromRecord(this.nextRecord));
            duration = Duration.between(now, next);
        } catch (final Exception e) {
            logger.info("Failed to parse timstamps", e);
            duration = Duration.ofMillis(1);
        }

        triggerNextRead(duration);
    }

    private void triggerNextRead(final Duration originalDuration) {

        Duration duration = originalDuration;

        if (duration.isNegative()) {

            duration = Duration.ZERO;
            logger.debug("Zeroed negative duration");

        } else {

            duration = originalDuration;
            if (this.durationMultipliedBy != null) {
                duration = duration.multipliedBy(this.durationMultipliedBy);
            }
            if (this.durationDividedBy != null) {
                duration = duration.dividedBy(this.durationDividedBy);
            }
            logger.debug("Applied transformations: {} -> {}", originalDuration, duration);

        }

        logger.debug("Schedule next read in: {}", duration);

        final Instant now = Instant.now();

        if (this.nextUpdate != null) {
            final Duration diff = Duration.between(this.nextUpdate, now);
            final Duration corrected = duration.minus(diff);
            logger.debug("Correcting duration - {} -> {} (diff: {})", duration, corrected, diff);
            duration = corrected;
        }

        this.nextUpdate = now.plus(duration);

        Durations.consume(duration,
                (delay, unit) -> this.executor.get().schedule(() -> this.context.run(this::readNext), delay, unit));
    }

    private void setCurrentRecord(final CSVRecord record) {
        logger.debug("Current record: {}", record);
        this.record = record;
    }

    private long fromRecord(final CSVRecord record) throws Exception {
        try {
            final long ts = Long.parseLong(record.get(this.timestampColumn));
            logger.trace("Raw TS value: {}", ts);
            return TimeUnit.MILLISECONDS.convert(ts, this.timestampUnit);
        } catch (final Exception e) {
            throw new Exception("Failed to parse timestamp", e);
        }
    }

    private void fireUpdated() {
        triggerOut("updated");
    }

    private void fireEndOfFile() {
        triggerOut("completed");
    }

    @Override
    public void connectDataOut(final String portName, final DataPlugOut plug) {
        if (portName.startsWith("record/")) {
            if (getDataPortOut(portName) == null) {
                final String name = portName.substring("record/".length());
                registerDataOut(portName, () -> getRecord(name));
            }
        }

        super.connectDataOut(portName, plug);
    }

    private ValueResult getRecord(final ValueRequest request) {
        return ValueResult.of(this.record, this.record.toMap());
    }

    private String getRecord(final String columnName) {
        if (this.record == null) {
            return null;
        }

        return this.record.get(columnName);
    }
}

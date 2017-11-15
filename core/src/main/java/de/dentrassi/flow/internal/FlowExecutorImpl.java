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
package de.dentrassi.flow.internal;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlowExecutorImpl implements FlowExecutor {

    private static final Logger logger = LoggerFactory.getLogger(FlowExecutorImpl.class);

    private static final AtomicLong THREAD_COUNTER = new AtomicLong();

    private volatile boolean running = false;

    private final LinkedBlockingQueue<Runnable> contextTasks = new LinkedBlockingQueue<>();

    private final Thread thread;

    public FlowExecutorImpl() {
        this.thread = new Thread(this::contextRunner);
        this.thread.setName("flow-" + THREAD_COUNTER.getAndIncrement());
    }

    public synchronized void start() {
        if (this.running) {
            // already running
            return;
        }
        if (this.thread.isAlive()) {
            // scheduled to terminate
            return;
        }
        this.running = true;
        this.thread.start();
    }

    public void stop() throws InterruptedException {
        synchronized (this) {
            if (!this.running) {
                return;
            }

            this.running = false;
            notifyAll();
        }

        this.thread.join();
    }

    @Override
    public void execute(final Runnable command) {
        Objects.requireNonNull(command);

        this.contextTasks.add(command);
    }

    @Override
    public boolean isExecutorThread() {
        return Thread.currentThread().equals(this.thread);
    }

    protected void contextRunner() {

        while (this.running) {
            try {
                final Runnable command = this.contextTasks.take();
                if (command != null) {
                    command.run();
                }
            } catch (final Exception e) {
                logger.warn("Failed to process task", e);
                continue;
            }
        }

    }

}
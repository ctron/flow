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
package de.dentrassi.flow;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dentrassi.flow.internal.FlowExecutor;
import de.dentrassi.flow.internal.FlowRunner;
import de.dentrassi.flow.spi.type.ComponentFactory;

public class Flow implements AutoCloseable {

    private static class FlowExecutorImpl implements FlowExecutor {

        private static final AtomicLong THREAD_COUNTER = new AtomicLong();

        private boolean running;

        private final LinkedList<Runnable> contextTasks = new LinkedList<>();

        private final Thread thread;

        public FlowExecutorImpl() {
            this.thread = new Thread(this::contextRunner);
            this.thread.setName("flow-" + THREAD_COUNTER.getAndIncrement());

            synchronized (this) {
                this.running = true;
            }
        }

        public void start() {
            this.thread.start();
        }

        public void stop() throws InterruptedException {
            synchronized (this) {
                this.running = false;
                notifyAll();
            }

            this.thread.join();
        }

        @Override
        public void execute(final Runnable command) {
            Objects.requireNonNull(command);

            synchronized (this) {
                this.contextTasks.add(command);
                notifyAll();
            }
        }

        @Override
        public boolean isExecutorThread() {
            return Thread.currentThread().equals(this.thread);
        }

        protected synchronized void contextRunner() {
            while (this.running) {

                // process first, we might already have tasks when we got created

                /*
                 * Do this until we have an empty task list. It may be that executing tasks
                 * actually creates new tasks in the context thread. Which we need to process as
                 * well.
                 */

                while (!this.contextTasks.isEmpty()) {
                    processContextTasks();
                }

                // now wait

                try {
                    wait();
                } catch (final InterruptedException e) {
                }
            }
        }

        private void processContextTasks() {

            // make a copy

            final Runnable[] tasks = this.contextTasks.toArray(new Runnable[this.contextTasks.size()]);
            this.contextTasks.clear();

            // run tasks

            for (final Runnable runnable : tasks) {
                try {
                    runnable.run();
                } catch (final Exception e) {
                    logger.info("Context task failed", e);
                }
            }
        }

    }

    private static final Logger logger = LoggerFactory.getLogger(Flow.class);

    private final FlowRunner runner;
    private final FlowExecutorImpl executor;

    public Flow(final ComponentFactory componentFactory) {
        this.executor = new FlowExecutorImpl();

        this.runner = new FlowRunner(this.executor, componentFactory);

        this.executor.start();
    }

    public void start() {
        this.executor.execute(this.runner::start);
    }

    public void stop() {
        this.executor.execute(this.runner::stop);
    }

    public void modify(final Consumer<FlowContext> consumer) {
        Objects.requireNonNull(consumer);

        this.executor.execute(() -> {
            consumer.accept(this.runner);
        });
    }

    @Override
    public void close() throws Exception {
        this.executor.stop();
    }
}

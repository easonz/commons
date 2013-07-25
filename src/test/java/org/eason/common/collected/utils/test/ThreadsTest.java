/*
 * $HeadURL: https://springside.googlecode.com/svn/springside4/trunk/modules/core/src/test/java/org/springside/modules/utils/ThreadsTest.java $
 * $Id: ThreadsTest.java 1680 2012-02-11 12:58:02Z calvinxiu $
 * Copyright (c) 2010 by Ericsson, all rights reserved.
 */

package org.eason.common.collected.utils.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eason.common.collected.utils.Threads;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadsTest {

	@Test
	public void gracefulShutdown() throws InterruptedException {

		Logger logger = LoggerFactory.getLogger("test");
		LogbackListAppender appender = new LogbackListAppender();
		appender.addToLogger("test");

		//time enough to shutdown
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Runnable task = new Task(logger, 500, 0);
		pool.execute(task);
		Threads.gracefulShutdown(pool, 1000, 1000, TimeUnit.MILLISECONDS);
		assertTrue(pool.isTerminated());
		assertNull(appender.getFirstLog());

		//time not enough to shutdown,call shutdownNow
		appender.clearLogs();
		pool = Executors.newSingleThreadExecutor();
		task = new Task(logger, 1000, 0);
		pool.execute(task);
		Threads.gracefulShutdown(pool, 500, 1000, TimeUnit.MILLISECONDS);
		assertTrue(pool.isTerminated());
		assertEquals("InterruptedException", appender.getFirstLog().getMessage());

		//self thread interrupt while calling gracefulShutdown
		appender.clearLogs();

		final ExecutorService self = Executors.newSingleThreadExecutor();
		task = new Task(logger, 100000, 0);
		self.execute(task);

		final CountDownLatch lock = new CountDownLatch(1);
		Thread thread = new Thread(new Runnable() {
			public void run() {
				lock.countDown();
				Threads.gracefulShutdown(self, 200000, 200000, TimeUnit.MILLISECONDS);
			}
		});
		thread.start();
		lock.await();
		thread.interrupt();
		Threads.sleep(500);
		assertEquals("InterruptedException", appender.getFirstLog().getMessage());
	}

	@Test
	public void normalShutdown() throws InterruptedException {

		Logger logger = LoggerFactory.getLogger("test");
		LogbackListAppender appender = new LogbackListAppender();
		appender.addToLogger("test");

		//time not enough to shutdown,write error log.
		appender.clearLogs();
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Runnable task = new Task(logger, 1000, 0);
		pool.execute(task);
		Threads.normalShutdown(pool, 500, TimeUnit.MILLISECONDS);
		assertTrue(pool.isTerminated());
		assertEquals("InterruptedException", appender.getFirstMessage());
	}

	static class Task implements Runnable {
		private final Logger logger;

		private int runTime = 0;

		private final int sleepTime;

		Task(Logger logger, int sleepTime, int runTime) {
			this.logger = logger;
			this.sleepTime = sleepTime;
			this.runTime = runTime;
		}

		public void run() {
			System.out.println("start task");
			if (runTime > 0) {
				long start = System.currentTimeMillis();
				while (System.currentTimeMillis() - start < runTime) {
				}
			}

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				logger.warn("InterruptedException");
			}
		}
	}
}

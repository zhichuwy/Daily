package com.yang.juc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadState {

	private static Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {
		
		
		
	}

	public void interruptTest3() throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (;;) {

				}
			}
		});

		t.start();
		t.interrupt();

		System.out.println(t.isInterrupted());
		System.out.println(t.interrupted());// = Thread.interrupted()
		System.out.println(Thread.interrupted());
		System.out.println(t.isInterrupted());

		/**
		 * public static boolean interrupted() { return
		 * currentThread().isInterrupted(true); }
		 */

		t.join();
	}

	public void interruptTest2() throws InterruptedException {

		Thread t = new Thread(new Runnable() {
			public void run() {

				try {
					Thread.sleep(6000000);
					System.out.println("awake");

				} catch (InterruptedException e) {
					System.out.println("be interrupted while sleeping");
					return; // 返回主线程
				}
				System.out.println("leave normally");
			}
		});

		t.start();
		Thread.sleep(1000);
		t.interrupt();
		t.join();
		System.out.println("main end");

	}

	public void interruptTest() {

		Thread t = new Thread(new Runnable() {
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					System.out.println(0);
				}
			}
		});

		t.start();

		try {
			Thread.sleep(1000);
			// 线程会继续执行，判断：interrupted清除中断标志 isInterrupted不清除
			// t.interrupt();
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void waitTest() {

		Thread t = new Thread(new Runnable() {
			public void run() {
				synchronized (obj) {
					try {
						System.out.println("waiting");
						obj.wait(3000);
						System.out.println("hh");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// t.interrupt();

		System.out.println("main");
		synchronized (obj) {
			obj.notify();
		}
	}

	/*
	public void creatThread() {

		MyThread t1 = new MyThread();
		Thread t2 = new Thread(new RunableTask());

		// 异步任务
		FutureTask<String> ft = new FutureTask<String>(new CallerTask());
		Thread t3 = new Thread(ft);

		t1.start();
		t2.start();
		t3.start();

		// t1.join();
		// t2.join();
		// t3.join();执行顺序？

		try {
			String result = ft.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	} */
}

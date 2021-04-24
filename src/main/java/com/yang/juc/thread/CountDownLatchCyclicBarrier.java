package com.yang.juc.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class CountDownLatchCyclicBarrier {
	
	
	
	

	CountDownLatch cd = new CountDownLatch(3);
	// count the number of times countDown must be invoked
	// before threads can pass through await

	/*
	 * Creates a new CyclicBarrier that will trip when the given number of parties
	 * (threads) are waiting upon it, and which will execute the given barrier
	 * action when the barrier is tripped, performed by the last thread entering the
	 * barrier.
	 * 
	 * Parameters: parties: the number of threads that must invoke await before the
	 * barrier is tripped barrierAction: the command to execute when the barrier
	 * istripped, or null if there is no action
	 */
	CyclicBarrier cb = new CyclicBarrier(5, new Runnable() {
		@Override
		public void run() {
			System.out.println("1 2 3 4 5 all ok");
		}
	});
	
	//@Test
	public void f2() throws InterruptedException {
		cb();
		Thread.sleep(6000);
	}
	
	public void cb() {
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("ready");
					try {
						cb.await();
						System.out.println("go");
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
	public void cd() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("1 preparing");
				try {
					Thread.sleep(1000);
					System.out.println("1 ready");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cd.countDown();
				
				System.out.println("?????????????"); //´Ë´¦²»×èÈû
				
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("2 preparing");
				try {
					Thread.sleep(2000);
					System.out.println("2 ready");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cd.countDown();
			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("3 preparing");
				try {
					Thread.sleep(3000);
					System.out.println("3 ready");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cd.countDown();
			}
		});

		t1.start();
		t2.start();
		t3.start();

	}
	

	@Test
	public void f1() throws InterruptedException {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("waiting 1 2 3 ready");
				try {
					cd.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("1 2 3 all ok");
			}
		}).start();
		
		cd();
		
		Thread.sleep(10000);
	}

}

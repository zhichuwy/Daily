package com.yang.juc.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class ProduceConsume {

	private ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<String>(5);
	private AtomicInteger ai = new AtomicInteger(0);
	private volatile boolean b = true;
	
	CopyOnWriteArrayList<String> plist = new CopyOnWriteArrayList<String>();
	CopyOnWriteArrayList<String> clist = new CopyOnWriteArrayList<String>();

	public void Produce() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				
				while (b) {
					String content = "P0-" + ai.getAndIncrement();
					try {
						bq.put(content);
						plist.add(content);
						System.out.println("put:" + content);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				
				while (b) {
					String content = "P1-" + ai.getAndIncrement();
					try {
						bq.put(content);
						plist.add(content);
						System.out.println("put:" + content);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}

	public void Consume() {

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(b) {
						try {
							String content = bq.take();
							clist.add(content);
							System.out.println("take:" + content);
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}

	@Test
	public void start() throws Exception {

		Produce();
		Consume();

		Thread.sleep(1000 * 3);
		
		b = false;
		
		System.out.println(plist);
		System.out.println(clist);
	}
}

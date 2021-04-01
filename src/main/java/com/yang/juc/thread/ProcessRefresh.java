package com.yang.juc.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.junit.Test;

public class ProcessRefresh {
	
	private volatile int p = 0;
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	//模拟下载进度
	Thread t1 = new Thread(new Runnable() {
		
		Random rnd = new Random();
		
		@Override
		public void run() {
			
			while(p < 1000) {
				
				lock.writeLock().lock();
				p = p + rnd.nextInt(25);
				if( p >= 1000) {
					p = 1000;
				}
				// System.out.println("p=" + p); 可能未被及时读取到
				lock.writeLock().unlock();
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	//刷新进度条
	Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			int cur = p / 10;
			while(cur < 100) {
				
				lock.readLock().lock();
				System.out.print("p=" + p);
				cur = p / 10;
				
				System.out.print("[");
				for (int i = 0; i < cur; i++) {
					System.out.print('.');
				}
				System.out.print("]" + cur + '%');
				System.out.println();
				
				lock.readLock().unlock();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
	
	
	@Test
	public void f() {

		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("OK");
	}
	
	
}

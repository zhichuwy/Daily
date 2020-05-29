package com.yang.juc.thread;

public class RunableTask implements Runnable {

	public void run() {
		
		try {
			Thread.sleep(2000);
			
			System.out.println("t2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

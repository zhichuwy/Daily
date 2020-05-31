package com.yang.juc.threadlocal;

public class ThreadLocaltest {
	
	static ThreadLocal<String> var = new ThreadLocal<String>();
	
	static void print(String s) {
		System.out.println(s + ":" + var.get());
		//var.remove();
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				var.set("t1");
				print("t1");
				System.out.println("t1:" + var.get());
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				var.set("t2");
				print("t2");
				System.out.println("t2:" + var.get());
			}
		});
		
		t1.start();
		t2.start();
	} 
}
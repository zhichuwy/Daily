package com.yang.juc.threadlocal;

public class TestTL {
	
	public static ThreadLocal<String> var = new ThreadLocal<String>();
	
	// 子线程可以访问父线程  可继承ThreadLocal
	public static InheritableThreadLocal<String> var2 = new InheritableThreadLocal<String>();
	
	public static void main(String[] args) {
		var.set("var");
		var2.set("var2");
		
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("t-var:" + var.get());
				System.out.println("t-var2:" + var2.get());
			}
		});
		
		t.start();
		System.out.println("main-var:" + var.get());
		System.out.println("main-var2:" + var2.get());
	}

}

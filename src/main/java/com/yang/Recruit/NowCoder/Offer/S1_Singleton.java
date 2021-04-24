package com.yang.Recruit.NowCoder.Offer;

// 类注释 方法注释  => "/**" + Enter

/**
 * @author wu_ya
 * 
 */
public class S1_Singleton {

	private static S1_Singleton instance;
	private S1_Singleton() {

	}
	
	public void fun() {
		System.out.println("单例实例化成功");
	}

	// 线程不安全
	public static S1_Singleton get() {
		if (instance == null) {
			instance = new S1_Singleton();
		}
		return instance;
	}

	// 线程安全

	// 懒汉模式-直接加锁
	// private S1_Singleton(){}
	public static synchronized S1_Singleton get1() {
		if (instance == null) {
			instance = new S1_Singleton();
		}

		return instance;
	}
	
	
	
	// 懒汉模式-双重校验锁
	private static volatile S1_Singleton instance2;
	// private S1_Singleton(){}
	public static S1_Singleton get2() {
		if(instance2 == null) { //X: 单例判断 必需步骤
			synchronized (S1_Singleton.class) {
				if(instance2 == null) { // t1 t2 均已执行完X步骤，其中之一必先完成同步块 后无需再次实例化
					instance2 = new S1_Singleton(); // Y: 1分配内存；2构造初始化；3实例指向内存空间
					// volatile保证123顺序执行 否则可能13<X判非空 返回,Z实际为空>2
				}
			}
		}
		return instance2; // Z: Y132执行 会(volatile作用 防止Y指令重排)
	}
	
	

	// 饿汉模式
	private static S1_Singleton instance3 = new S1_Singleton();
	// private S1_Singleton(){}
	public static S1_Singleton get3() {
		return instance3;
	}
	
	

	// 静态内部类
	// private S1_Singleton(){}
	private static class SingletonHolder{
		private static final S1_Singleton INSTANCE = new S1_Singleton();
	}
	public static S1_Singleton get4() {
		return SingletonHolder.INSTANCE;
	}
	
	
	public static void main(String[] args) {
		S1_Singleton s = S1_Singleton.get4();
		s.fun();
		
	}

}

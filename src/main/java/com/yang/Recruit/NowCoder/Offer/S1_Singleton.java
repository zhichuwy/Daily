package com.yang.Recruit.NowCoder.Offer;

import org.junit.Test;

// 类注释 方法注释  => "/**" + Enter

/**
 * @author wu_ya
 * 
 */
public class S1_Singleton {

	// 线程不安全
	private static S1_Singleton instance1 = null;

	private S1_Singleton() {

	}

	public S1_Singleton get() {
		if (instance1 == null) {
			instance1 = new S1_Singleton();
		}
		return instance1;
	}

	// 线程安全
	// 直接加锁

	
	// 饿汉模式
	
	
	//

}

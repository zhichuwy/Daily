package com.yang.juc.atomic;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeTest {

	// static Unsafe unsafe = Unsafe.getUnsafe();
	// 直接使用 => java.lang.SecurityException: Unsafe

	static Unsafe unsafe;
	static long stateOffset;
	private volatile long var = 0;

	static {
		try {
			// 反射获取，
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
			stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("var"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UnsafeTest test = new UnsafeTest();
		Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
		System.out.println(success);
	}

}

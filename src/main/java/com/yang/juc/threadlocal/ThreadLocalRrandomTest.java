package com.yang.juc.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRrandomTest {

	public static void main(String[] args) {
		
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(tlr.nextInt(10));
		}
	}

}

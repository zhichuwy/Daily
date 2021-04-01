package com.yang.lambda;

import java.util.function.Function;

public class test implements Function<Integer, String> {

	public void f1() {
		
	}
	
	
	public static void main(String[] args) {
		
		Thread t = new Thread(()->System.out.println("lambda–¥∑®"));
		t.start();
	}


	@Override
	public String apply(Integer t) {
		// TODO Auto-generated method stub
		return null;
	}

}

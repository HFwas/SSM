package com.hf.proxy;

public class Test {
	
	public static void main(String[] args) {
		
		MathI mathI = new MathImpl();
		int result = mathI.add(1, 1);
		System.out.println(result);
	}
}

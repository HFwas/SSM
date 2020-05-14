package com.hf.proxy;

public class Test {
	
	public static void main(String[] args) {
		
		/*MathI mathI = new MathImpl();
		int result = mathI.add(1, 1);
		System.out.println(result);*/
		
		ProxyUtil pUtil = new ProxyUtil(new MathImpl());
		MathI math = (MathI)pUtil.getProxy();
		int i = math.div(4, 0);
		System.out.println(i);
	}
}

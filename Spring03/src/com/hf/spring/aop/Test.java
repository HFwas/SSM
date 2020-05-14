package com.hf.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
		MathI math = ac.getBean("mathImpl", MathI.class);
		int i = math.div(2, 1);
		System.out.println(i);
		
		/*TestHandler bean = ac.getBean("testHandler", TestHandler.class);
		bean.test();*/
	}
}

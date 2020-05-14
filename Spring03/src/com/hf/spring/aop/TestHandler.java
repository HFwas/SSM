package com.hf.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class TestHandler {
	
	public void test(){
		System.out.println("切入点测试");
	}
}	

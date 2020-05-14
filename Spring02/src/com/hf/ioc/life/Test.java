package com.hf.ioc.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hf.ioc.scope.Student;

public class Test {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("life.xml");
		Person person = ac.getBean("person", Person.class);
		System.out.println(person);
		ac.close( );
	}
}

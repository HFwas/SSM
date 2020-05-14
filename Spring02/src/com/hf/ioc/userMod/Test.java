package com.hf.ioc.userMod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hf.ioc.userMod.controller.UserController;
import com.hf.ioc.userMod.dao.UserDaoImpl;
import com.hf.ioc.userMod.service.UserServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("user.xml");
		UserController uc = ac.getBean("aaa", UserController.class);
		/*System.out.println(uc);
		UserServiceImpl us = ac.getBean("userServiceImpl",UserServiceImpl.class);
		System.out.println(us);
		UserDaoImpl ud = ac.getBean("userDaoImpl", UserDaoImpl.class);
		System.out.println(ud);*/
		uc.addUser();
		
	}
	
}

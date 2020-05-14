package com.hf.ioc.userMod.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	public void  addUser() {
		System.out.println("UserDaoImpl：：添加成功");
	}
	
	public  UserDaoImpl() {
		System.out.println("UserDaoImpl");
	}
}

package com.hf.ioc.userMod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hf.ioc.userMod.dao.UserDao;
import com.hf.ioc.userMod.dao.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	/** @Qualifier(value="userDaoMybatisImpl")*/
	private UserDao userDao;
	
	/*@Autowired
	@Qualifier(value="userDaoMybatisImpl")
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}*/
	
	public void addUser() {
		userDao.addUser();
	}
	
	public  UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}
}

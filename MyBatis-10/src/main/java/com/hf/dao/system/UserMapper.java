package com.hf.dao.system;

import java.util.List;

import com.hf.model.system.User;

//思想：AOP:面向切面编程
public interface UserMapper {
	
	public User queryUserByLoginNameAndPssword(User user);
	
}

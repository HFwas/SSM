package com.hf.dao.system;

import java.util.List;

import com.hf.model.system.User;

//思想：AOP:面向切面编程
public interface UserMapper {


	// 增加
	public int addUser(User user);

	// 删除
	public int deleteUser(int userId);

	// 修改
	public int updateUser(User user);

	// 查询所有
	public List<User> queryAllUser();

	// 查询通过ID
	public User queryUserByUserId(int userId);
}

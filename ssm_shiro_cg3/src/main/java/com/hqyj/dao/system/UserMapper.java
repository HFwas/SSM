package com.hqyj.dao.system;

import java.util.List;

import com.hqyj.model.system.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	// ###############################自己程序#####################################
	User queryUserByUsernameAndPassword(User user);

	List<User> queryAllUser();

	User queryUserByUsername(String username);
}
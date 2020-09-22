package com.hqyj.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.system.UserMapper;
import com.hqyj.model.system.User;
import com.hqyj.service.system.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByUsernameAndPassword(User user) {
		return userMapper.queryUserByUsernameAndPassword(user);
	}

	@Override
	public List<User> queryAllUser() {
		return userMapper.queryAllUser();
	}

	@Override
	public int addUserByUser(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int deleteUserByUserId(int userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public User queryUserByUserId(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateUserByUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

}

package com.hqyj.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.system.UserRoleMapper;
import com.hqyj.model.system.UserRole;
import com.hqyj.service.system.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public int deleteUserRoleByUserId(int userId) {
		return userRoleMapper.deleteUserRoleByUserId(userId);
	}

	@Override
	public int addUserRoleByUserRole(UserRole userRole) {
		return userRoleMapper.insertSelective(userRole);
	}

}

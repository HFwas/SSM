package com.hqyj.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.system.RoleMapper;
import com.hqyj.model.system.Role;
import com.hqyj.service.system.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> queryAllRole() {
		return roleMapper.queryAllRole();
	}

	@Override
	public int addRoleByRole(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public int deleteRoleByRoleId(int roleId) {
		return roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public Role queryRoleByRoleId(int roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateRoleByRole(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public Role queryRole_db_xzByUserId(int userId) {
		
		return roleMapper.queryRole_db_xzByUserId(userId);
	}

}

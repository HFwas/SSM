package com.hqyj.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.system.RolePermissionsMapper;
import com.hqyj.model.system.RolePermissions;
import com.hqyj.service.system.RolePermissionsService;

@Service
public class RolePermissionsServiceImpl implements RolePermissionsService {
	@Autowired
	private RolePermissionsMapper rolePermissionsMapper;

	@Override
	public int deleteRolePermissionsByRoleId(int roleId) {
		return rolePermissionsMapper.deleteRolePermissionsByRoleId(roleId);
	}

	@Override
	public int addRolePermissionsByRolePermissions(RolePermissions rolePermissions) {
		return rolePermissionsMapper.insertSelective(rolePermissions);
	}

}

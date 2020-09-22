package com.hqyj.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.system.PermissionsMapper;
import com.hqyj.model.system.Permissions;
import com.hqyj.service.system.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionsMapper permissionsMapper;

	@Override
	public List<Permissions> queryAllPermissions() {
		return permissionsMapper.queryAllPermissions();
	}

	@Override
	public int addPermissionsByPermissions(Permissions permissions) {
		return permissionsMapper.insertSelective(permissions);
	}

	@Override
	public int deletePermissionsByPermissionsId(int permissionsId) {
		return permissionsMapper.deleteByPrimaryKey(permissionsId);
	}

	@Override
	public Permissions queryPermissionsByPermissionsId(int permissionsId) {
		return permissionsMapper.selectByPrimaryKey(permissionsId);
	}

	@Override
	public int updatePermissionsByPermissions(Permissions permissions) {
		return permissionsMapper.updateByPrimaryKeySelective(permissions);
	}

	@Override
	public List<Permissions> queryPermissions_db_xzByRoleId(int roleId) {
		return permissionsMapper.queryPermissions_db_xzByRoleId(roleId);
	}

	@Override
	public List<Permissions> queryPermissions_db_xzByUserIdAndType(int userId) {
		// 复杂业务
		return permissionsMapper.queryPermissions_db_xzByUserIdAndType(userId);
	}

	@Override
	public List<Permissions> queryPermissions_db_xzByPid(int pId) {
		return permissionsMapper.queryPermissions_db_xzByPid(pId);
	}

}

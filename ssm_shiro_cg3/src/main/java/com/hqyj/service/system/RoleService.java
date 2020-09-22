package com.hqyj.service.system;

import java.util.List;

import com.hqyj.model.system.Role;

public interface RoleService {

	List<Role> queryAllRole();

	int addRoleByRole(Role role);

	int deleteRoleByRoleId(int roleId);

	Role queryRoleByRoleId(int roleId);

	int updateRoleByRole(Role role);

	Role queryRole_db_xzByUserId(int userId);

}

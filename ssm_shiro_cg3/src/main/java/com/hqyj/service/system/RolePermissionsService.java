package com.hqyj.service.system;

import com.hqyj.model.system.RolePermissions;

public interface RolePermissionsService {

	int deleteRolePermissionsByRoleId(int roleId);

	int addRolePermissionsByRolePermissions(RolePermissions rolePermissions);



}

package com.hqyj.service.system;

import java.util.List;

import com.hqyj.model.system.Permissions;

public interface PermissionService {

	List<Permissions> queryAllPermissions();

	int addPermissionsByPermissions(Permissions permissions);

	int deletePermissionsByPermissionsId(int permissionsId);

	Permissions queryPermissionsByPermissionsId(int permissionsId);

	int updatePermissionsByPermissions(Permissions permissions);

	List<Permissions> queryPermissions_db_xzByRoleId(int roleId);

	List<Permissions> queryPermissions_db_xzByUserIdAndType(int userId);

	List<Permissions> queryPermissions_db_xzByPid(int pId);

}

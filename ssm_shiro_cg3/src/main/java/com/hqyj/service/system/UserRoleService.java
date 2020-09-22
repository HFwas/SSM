package com.hqyj.service.system;

import com.hqyj.model.system.UserRole;

public interface UserRoleService {

	int deleteUserRoleByUserId(int userId);

	int addUserRoleByUserRole(UserRole userRole);

}

package frame.utils.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.hqyj.service.system.PermissionService;
import com.hqyj.service.system.RolePermissionsService;
import com.hqyj.service.system.RoleService;
import com.hqyj.service.system.UserRoleService;
import com.hqyj.service.system.UserService;

public class BaseController {
	/* 1.系统模块 */
	@Autowired
	public UserService userService;
	@Autowired
	public RoleService roleService;
	@Autowired
	public PermissionService permissionService;
	@Autowired
	public UserRoleService userRoleService;
	@Autowired
	public RolePermissionsService rolePermissionsService;

	/* 2.邮件模块 */
}

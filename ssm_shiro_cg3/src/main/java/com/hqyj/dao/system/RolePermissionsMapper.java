package com.hqyj.dao.system;

import com.hqyj.model.system.RolePermissions;

public interface RolePermissionsMapper {
    int deleteByPrimaryKey(Integer rolePermissionsId);

    int insert(RolePermissions record);

    int insertSelective(RolePermissions record);

    RolePermissions selectByPrimaryKey(Integer rolePermissionsId);

    int updateByPrimaryKeySelective(RolePermissions record);

    int updateByPrimaryKey(RolePermissions record);

	int deleteRolePermissionsByRoleId(int roleId);
}
package com.hqyj.dao.system;

import java.util.List;

import com.hqyj.model.system.Permissions;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer permissionsId);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer permissionsId);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);

	List<Permissions> queryAllPermissions();

	List<Permissions> queryPermissions_db_xzByRoleId(int roleId);

	List<Permissions> queryPermissions_db_xzByUserIdAndType(int userId);

	List<Permissions> queryPermissions_db_xzByPid(int pId);

	List<Permissions> queryPermissionsByUserId(Integer userId);
}
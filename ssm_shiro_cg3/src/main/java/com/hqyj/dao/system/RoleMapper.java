package com.hqyj.dao.system;

import java.util.List;

import com.hqyj.model.system.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	List<Role> queryAllRole();

	Role queryRole_db_xzByUserId(int userId);
}
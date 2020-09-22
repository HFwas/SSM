package com.hqyj.model.system;

public class RolePermissions {
    private Integer rolePermissionsId;

    private Integer roleId;

    private Integer permissionsId;

    public Integer getRolePermissionsId() {
        return rolePermissionsId;
    }

    public void setRolePermissionsId(Integer rolePermissionsId) {
        this.rolePermissionsId = rolePermissionsId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Integer permissionsId) {
        this.permissionsId = permissionsId;
    }

	@Override
	public String toString() {
		return "RolePermissions [rolePermissionsId=" + rolePermissionsId + ", roleId=" + roleId + ", permissionsId="
				+ permissionsId + "]";
	}
    
}
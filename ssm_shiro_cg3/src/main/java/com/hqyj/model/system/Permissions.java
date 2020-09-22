package com.hqyj.model.system;

import java.util.Date;

public class Permissions {
    private Integer permissionsId;

    private Integer pId;

    private String permissionsName;

    private String permissionsDesc;

    private String permissionsUrl;

    private String percode;

    private String type;

    private Date createTime;

    public Integer getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Integer permissionsId) {
        this.permissionsId = permissionsId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public String getPermissionsDesc() {
        return permissionsDesc;
    }

    public void setPermissionsDesc(String permissionsDesc) {
        this.permissionsDesc = permissionsDesc;
    }

    public String getPermissionsUrl() {
        return permissionsUrl;
    }

    public void setPermissionsUrl(String permissionsUrl) {
        this.permissionsUrl = permissionsUrl;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Permissions [permissionsId=" + permissionsId + ", pId=" + pId + ", permissionsName=" + permissionsName
				+ ", permissionsDesc=" + permissionsDesc + ", permissionsUrl=" + permissionsUrl + ", percode=" + percode
				+ ", type=" + type + ", createTime=" + createTime + "]";
	}
    
}
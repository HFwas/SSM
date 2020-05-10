package com.hf.model.system;

/**
 * 用户
 *
 */
public class User {
	/** ID */
	private int userId;
	/**姓名*/
	private String name;
	/**登录名*/
	private String loginName;
	/**密码*/
	private String password;
	/**盐*/
	private String salt;
	/**状态*/
	private String locked;
	/**创建时间*/
	private String createTime;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String name, String loginName, String password, String salt, String locked,
			String createTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.salt = salt;
		this.locked = locked;
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", loginName=" + loginName + ", password=" + password
				+ ", salt=" + salt + ", locked=" + locked + ", createTime=" + createTime + "]";
	}

	
}

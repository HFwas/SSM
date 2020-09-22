package com.hqyj.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqyj.dao.system.PermissionsMapper;
import com.hqyj.dao.system.UserMapper;
import com.hqyj.model.system.User;

public class ShiroRealm extends AuthenticatingRealm {
	// public class ShiroRealm extends AuthorizingRealm {
	// 注入dao接口mapper
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PermissionsMapper permissionsMapper;

	// 1.认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token1) throws AuthenticationException {
		// 1.令牌token对象拿出来
		UsernamePasswordToken token = (UsernamePasswordToken) token1;
		// 2.表单过来的用户名
		String username = token.getUsername();
		// 3.查询数据有没有记录
		User user_db = userMapper.queryUserByUsername(username);
		// 4.根据user_db对象具体情况，可以抛出shiro定义的异常
		if (user_db == null) {
			throw new UnknownAccountException("用户名或密码有误，请重新输入！");
		}
		if (user_db.getState() == "0") {
			throw new UnknownAccountException("账号已经被管理员禁用！");
		}
		// 5.进一步用shiro框架判断密码是否正确
		AuthenticationInfo info = new SimpleAuthenticationInfo(user_db, user_db.getPassword(), null, this.getName());
		return info;
	}

	// // 2.授权
	// @Override
	// protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection
	// principals) {
	// // 从 principals获取主身份信息
	// // 将getPrimaryPrincipal方法返回值转为真实身份类型
	// // （在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
	// User user_db = (User) principals.getPrimaryPrincipal();
	// // ############################# 查询权限################################
	// // 根据身份信息获取权限信息
	// // 从数据库获取到权限数据
	//
	// // List<String> permissions = new ArrayList<String>();
	// // permissions.add("user:userlist");// 用户列表
	// // permissions.add("user:add");// 用户增加
	//
	// List<Permissions> permissionsList = null;
	// try {
	// permissionsList =
	// permissionsMapper.queryPermissionsByUserId(user_db.getUserId());
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// List<String> menus = new ArrayList<String>();
	// if (permissionsList != null) {
	// for (Permissions permissions : permissionsList) {
	// menus.add(permissions.getPercode());
	// }
	// }
	// // ############################# 查询权限################################
	// // 查到权限数据，返回授权信息(要包括 上边的permissions)
	// SimpleAuthorizationInfo simpleAuthorizationInfo = new
	// SimpleAuthorizationInfo();
	// // 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
	// simpleAuthorizationInfo.addStringPermissions(menus);
	// return simpleAuthorizationInfo;
	// }
}

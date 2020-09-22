package com.hqyj.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.model.system.Role;
import com.hqyj.model.system.User;
import com.hqyj.model.system.UserRole;

import frame.utils.controller.BaseController;

@Controller
@RequestMapping("/roleController")
public class RoleController extends BaseController{

	@RequestMapping("/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role) {
		// 1.接受数据
		// 3.调用业务
		List<Role> role_dbList = roleService.queryAllRole();
		// 返回数据到页面
		model.addAttribute("role_dbList", role_dbList);
		// 2.跳转页面
		return "view/system/role/roleList";

	}

	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role) {
		// 1.接受数据

		// 3.调用业务

		// 2.跳转页面
		return "view/system/role/addRole";
	}

	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role) {
		// 1.接受数据

		// 3.调用业务
		// // ---》密码加密
		// String newPassword = new SimpleHash("MD5", user.getPassword(), null,
		// 1024).toHex();
		//
		// user.setPassword(newPassword);
		int n = roleService.addRoleByRole(role);
		// 2.跳转页面
		// 再去查询一次数据
		List<Role> role_dbList = roleService.queryAllRole();
		model.addAttribute("role_dbList", role_dbList);

		return "view/system/role/roleList";
	}

	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role, String roleIdStr) {
		// 1.接受数据

		// 3.调用业务
		// 字符串强转Int类型
		int roleId = Integer.parseInt(roleIdStr);
		int n = roleService.deleteRoleByRoleId(roleId);

		// 2.跳转页面
		// 再去查询一次数据
		List<Role> role_dbList = roleService.queryAllRole();
		model.addAttribute("role_dbList", role_dbList);

		return "view/system/role/roleList";
	}

	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role, String roleIdStr) {
		// 1.接受数据

		// 3.调用业务
		// 准备数据
		int roleId = Integer.parseInt(roleIdStr);
		Role role_db = roleService.queryRoleByRoleId(roleId);
		// 返回数据
		model.addAttribute("role_db", role_db);
		// 2.跳转页面
		return "view/system/role/updateRole";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role) {
		// 1.接受数据

		// 3.调用业务
		int n = roleService.updateRoleByRole(role);

		// 2.跳转页面
		// 再去查询一次数据
		List<Role> role_dbList = roleService.queryAllRole();
		model.addAttribute("role_dbList", role_dbList);

		return "view/system/role/roleList";
	}

	@RequestMapping("/FPRoleUI.do")
	public String FPRoleUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role, String userIdStr) {
		// 1.接受数据

		// 3.调用业务
		// a.准备用户用户信息
		int userId = Integer.parseInt(userIdStr);
		User user_db = userService.queryUserByUserId(userId);
		// b.准备角色对象列表数据
		List<Role> role_dbList = roleService.queryAllRole();

		// 返回数据
		model.addAttribute("user_db", user_db);
		model.addAttribute("role_dbList", role_dbList);

		// c.角色选中数据
		Role role_db_xz = roleService.queryRole_db_xzByUserId(userId);
		model.addAttribute("role_db_xz", role_db_xz);
		// 2.跳转页面
		return "view/system/role/FPRole";
	}

	@RequestMapping("/FPRole.do")
	public String FPRole(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role, UserRole userRole, String userIdStr, String roleIdStr) {
		// 1.接受数据
		int userId = Integer.parseInt(userIdStr);
		int roleId = Integer.parseInt(roleIdStr);
		userRole.setUserId(userId);
		userRole.setRoleId(roleId);

		// 通过userId先删除数据库相关角色
		int m = userRoleService.deleteUserRoleByUserId(userId);
		// 3.调用业务

		int n = userRoleService.addUserRoleByUserRole(userRole);
		// 2.跳转页面
		model.addAttribute("message", "分配角色成功继续分配吗？");
		// a.用户数据
		User user_db = userService.queryUserByUserId(userId);
		model.addAttribute("user_db", user_db);
		// b.角色对象列表数据
		List<Role> role_dbList = roleService.queryAllRole();
		model.addAttribute("role_dbList", role_dbList);
		// c.角色选中数据
		Role role_db_xz = roleService.queryRole_db_xzByUserId(userId);
		model.addAttribute("role_db_xz", role_db_xz);
		
		
		return "view/system/role/FPRole";
	}
}

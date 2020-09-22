package com.hqyj.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.model.system.Permissions;
import com.hqyj.model.system.Role;
import com.hqyj.model.system.RolePermissions;

import frame.utils.controller.BaseController;

@Controller
@RequestMapping("/permissionsController")
public class PermissionsController extends BaseController {

	@RequestMapping("/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Permissions permissions) {
		// 1.接受数据
		// 3.调用业务
		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		// 返回数据到页面
		model.addAttribute("permissions_dbList", permissions_dbList);
		// 2.跳转页面
		return "view/system/permissions/permissionsList";

	}

	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Permissions permissions) {
		// 1.接受数据
		// 3.调用业务
		// 准备父级节点数据
		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		model.addAttribute("permissions_dbList", permissions_dbList);
		// 2.跳转页面
		return "view/system/permissions/addPermissions";
	}

	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Permissions permissions) {
		// 1.接受数据

		// 3.调用业务

		int n = permissionService.addPermissionsByPermissions(permissions);
		// 2.跳转页面
		// 再去查询一次数据
		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		model.addAttribute("permissions_dbList", permissions_dbList);
		return "view/system/permissions/permissionsList";
	}

	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Permissions permissions, String permissionsIdStr) {
		// 1.接受数据

		// 3.调用业务
		// 字符串强转Int类型
		int permissionsId = Integer.parseInt(permissionsIdStr);
		int n = permissionService.deletePermissionsByPermissionsId(permissionsId);

		// 2.跳转页面
		// 再去查询一次数据
		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		model.addAttribute("permissions_dbList", permissions_dbList);
		return "view/system/permissions/permissionsList";
	}

	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Permissions permissions, String permissionsIdStr) {
		// 1.接受数据

		// 3.调用业务
		// a.准备数据修改数据
		int permissionsId = Integer.parseInt(permissionsIdStr);
		Permissions permissions_db = permissionService.queryPermissionsByPermissionsId(permissionsId);
		// 返回数据
		model.addAttribute("permissions_db", permissions_db);

		// b.准备数据父级节点所有数据

		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		model.addAttribute("permissions_dbList", permissions_dbList);

		// 2.跳转页面
		return "view/system/permissions/updatePermissions";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Permissions permissions) {
		// 1.接受数据
		// 3.调用业务
		int n = permissionService.updatePermissionsByPermissions(permissions);

		// 2.跳转页面
		// 再去查询一次数据
		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		model.addAttribute("permissions_dbList", permissions_dbList);
		return "view/system/permissions/permissionsList";
	}

	@RequestMapping("/FPPermissionsUI.do")
	public String FPPermissionsUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, Permissions permissions, Role role, String roleIdStr) {
		// 1.接受数据
		// 3.调用业务
		int roleId = Integer.parseInt(roleIdStr);
		System.err.println("--------------" + roleId);
		// a.准备角色数据
		Role role_db = roleService.queryRoleByRoleId(roleId);
		model.addAttribute("role_db", role_db);

		// b.准备菜单对象列表数据
		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		model.addAttribute("permissions_dbList", permissions_dbList);

		// c.准备菜单对象列表数据
		// #########操作内存##########
		// (XZ:选中)
		List<Permissions> permissions_db_xz = permissionService.queryPermissions_db_xzByRoleId(roleId);
		List<Integer> list = new ArrayList<Integer>();
		for (Permissions permissions2 : permissions_db_xz) {
			System.err.println(permissions2);
			list.add(permissions2.getPermissionsId());
		}
		model.addAttribute("ids", list);
		// #########操作内存##########

		// 2.跳转页面
		return "view/system/permissions/FPPermissionsUI";
	}

	@RequestMapping("/FPPermissions.do")
	public String FPPermissions(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, Permissions permissions, Role role, String roleIdStr, String[] permissionsIdStrs,
			RolePermissions rolePermissions) {
		// 1.接受数据
		int roleId = Integer.parseInt(roleIdStr);
		System.err.println("------------------------------" + roleId);
		// 通过roleId先删除数据库里面的相关菜单
		int m = rolePermissionsService.deleteRolePermissionsByRoleId(roleId);

		for (String permissionsIdStr : permissionsIdStrs) {
			int permissionsId = Integer.parseInt(permissionsIdStr);
			// 3.调用业务

			rolePermissions.setRoleId(roleId);
			rolePermissions.setPermissionsId(permissionsId);
			int n = rolePermissionsService.addRolePermissionsByRolePermissions(rolePermissions);
		}
		// 提示信息
		model.addAttribute("message", "分配菜单成功，继续分配吗？");
		// a.准备角色数据
		Role role_db = roleService.queryRoleByRoleId(roleId);
		model.addAttribute("role_db", role_db);

		// b.准备菜单对象列表数据
		List<Permissions> permissions_dbList = permissionService.queryAllPermissions();
		model.addAttribute("permissions_dbList", permissions_dbList);

		// c.准备菜单对象列表数据
		// #########操作内存##########
		// (XZ:选中)
		List<Permissions> permissions_db_xz = permissionService.queryPermissions_db_xzByRoleId(roleId);
		List<Integer> list = new ArrayList<Integer>();
		for (Permissions permissions2 : permissions_db_xz) {
			System.err.println(permissions2);
			list.add(permissions2.getPermissionsId());
		}
		model.addAttribute("ids", list);
		// #########操作内存##########

		// 2.跳转页面
		return "view/system/permissions/FPPermissionsUI";
	}
}

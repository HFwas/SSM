package com.hqyj.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.model.system.User;

import frame.utils.controller.BaseController;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {

	@RequestMapping("/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.接受数据
		System.err.println("------userController-------list()------");

		// 3.调用业务
		List<User> user_dbList = userService.queryAllUser();
		// for (User user_db : user_dbList) {
		// System.err.println("------userController-------list()------" +
		// user_db);
		// }
		// 返回数据到页面
		model.addAttribute("user_dbList", user_dbList);
		// 2.跳转页面
		return "view/system/user/userList";
	}

	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.接受数据

		// 3.调用业务

		// 2.跳转页面
		return "view/system/user/addUser";
	}

	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.接受数据
		System.err.println("------userController-------add()------" + user);

		// 3.调用业务
		// // ---》密码加密
		// String newPassword = new SimpleHash("MD5", user.getPassword(), null,
		// 1024).toHex();
		//
		// user.setPassword(newPassword);
		int n = userService.addUserByUser(user);
		// 2.跳转页面
		// 再去查询一次数据
		List<User> user_dbList = userService.queryAllUser();
		model.addAttribute("user_dbList", user_dbList);

		return "view/system/user/userList";
	}

	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user, String userIdStr) {
		// 1.接受数据
		System.err.println("------userController-------delete()------" + userIdStr);

		// 3.调用业务
		// 字符串强转Int类型
		int userId = Integer.parseInt(userIdStr);
		int n = userService.deleteUserByUserId(userId);

		// 2.跳转页面
		// 再去查询一次数据
		List<User> user_dbList = userService.queryAllUser();
		model.addAttribute("user_dbList", user_dbList);
		return "view/system/user/userList";
	}

	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user, String userIdStr) {
		// 1.接受数据
		System.err.println("------userController----1---updateUI()------" + userIdStr);

		// 3.调用业务
		// 准备数据
		int userId = Integer.parseInt(userIdStr);
		User user_db = userService.queryUserByUserId(userId);
		System.err.println("------userController----2---updateUI()------" + user_db);
		// 返回数据
		model.addAttribute("user_db", user_db);
		// 2.跳转页面
		return "view/system/user/updateUser";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		// 1.接受数据
		System.err.println("------userController-------update()------" + user);

		// 3.调用业务
		int n = userService.updateUserByUser(user);

		// 2.跳转页面
		// 再去查询一次数据
		List<User> user_dbList = userService.queryAllUser();
		model.addAttribute("user_dbList", user_dbList);
		return "view/system/user/userList";
	}

}

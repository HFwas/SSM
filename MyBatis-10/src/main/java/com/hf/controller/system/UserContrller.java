package com.hf.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hf.model.system.User;
import com.hf.service.system.UserService;
import com.hf.service.system.impl.UserServiceImpl;

@Controller
@RequestMapping("/userController")
public class UserContrller {
	
	//实例化业务接口
	UserService userService = new UserServiceImpl();
	
	@RequestMapping("/login.do")
	public String  login(HttpServletRequest request,HttpServletResponse response,HttpSession session,
			Model model, User user) {
		//接受数据
		System.out.println("===UserContrller==="+user);
		// 处理数据
		User user_db = userService.queryUserByLoginNameAndPssword(user);
		System.out.println("===user_db===="+user_db);
		if (user_db != null) {
			return "view/frame/main";
		}else {
			return "login";
		}
	}
}

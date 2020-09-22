package com.hqyj.controller.system;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hqyj.model.system.User;

@Controller
public class LoginController {
	@GetMapping(value = { "/login.jsp", "/" })
	public String login() {
		return "login";
	}

	@GetMapping("/view/frame/main.jsp")
	public String main() {
		return "/view/frame/main";
	}

	@PostMapping("/loginController/login.do")
	public String login(User user) {
		// 1.获取Subject对象，认证核心组件
		Subject subject = SecurityUtils.getSubject();
		// 2.将表单传过来的用户名和密码封装到token（令牌）对象
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		// 3.调用Subject对象里的方法，进行登录验证
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
			return "view/frame/loginError";
		}
		return "redirect:/view/frame/main.jsp";
	}
}

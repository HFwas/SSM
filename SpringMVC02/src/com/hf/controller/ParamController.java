package com.hf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hf.bean.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class ParamController {
	
	/**
	 * 在springmvc获取客户端传递的数据的方式
	 * 1.在处理请求的方法中，加入相应的形参，保证形参参数名和传递的数据的参数名保持一致，就可以自动赋值
	 * value:当不满足赋值条件时，可以使用value属性，指定映射关系
	 * required:设置形参是否必须被赋值，默认为true，必须赋值，若设置为false，则不必须赋值，因此形参的值为null
	 * defaultValue:若形参所获得值为null，则设置一个默认值，用在分页和模糊查询时
	 * @return
	 */
	/*@RequestMapping(value="/param",method=RequestMethod.POST)
	public String  param(@RequestParam(value="name",required=false,defaultValue="admin")String username,
				String password,String age ) {
		System.out.println("username="+username+",,password="+password+",,age="+age);
		return "success";
	}*/
	
	/**
	 * @RequestHeader:在处理请求的方法上，获取请求头信息，用法和@RequestParam一致
	 */
	/*@RequestMapping(value="/param",method=RequestMethod.POST)
	public String  param(@RequestHeader("Accept-Language")String AcceptLanguage) {
		System.out.println("Accept-Language:"+AcceptLanguage);
		return "success";
	}*/
	
	/**
	 * @CookieValue:在处理请求的方法上，获取cookie信息，用法和@RequestParam一致
	 */
	/*@RequestMapping(value="/param",method=RequestMethod.POST)
	public String  param(@CookieValue(value="JSESSIONID")String JSESSIONID) {
		System.out.println("JSESSIONID：："+JSESSIONID);
		return "success";
	}*/
	
	/**
	 * 可以使用POJO获取客户端数据，要求实体类对象中的属性名一定要和页面中表单元素中的name属性值一致，且支持级联关系
	 *可以通过设置形参的方式，来获取servletAPI
	 */
	/*@RequestMapping(value="/param",method=RequestMethod.POST)
	public String  param(User user,HttpServletRequest request) {
		String username = request.getParameter("username");
		System.out.println(username);
		//System.out.println(user);
		return "success";
	}*/
	
	
	/**
	 * springMVC处理请求过程中，往作用域中放值有以下三种方式
	 * 总结：根据modelandview源码调试，不管是用以下那种方式，最终都会吧model数据和view数据封装到一个modelandview
	 */
	/*@RequestMapping(value="/param",method=RequestMethod.POST)
	public ModelAndView  param() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username", "admin");//往request作用域里放值
		modelAndView.setViewName("success");//设置视图名称，完成页面跳转
		return modelAndView;
	}*/
	
	/*@RequestMapping(value="/param",method=RequestMethod.POST)
	public String  param(Map<String , Object> map) {
		map.put("username", "admin");//向作用域放值
		return "success";//放回视图名称
	}*/
	
	@RequestMapping(value="/param",method=RequestMethod.POST)
	public String  param(Model model) {
		model.addAttribute("username", "张三");
		return "success";//放回视图名称
	}
}

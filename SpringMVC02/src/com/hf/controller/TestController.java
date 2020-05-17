package com.hf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/controller")
public class TestController {
	
	/**
	 * localhost:8080/springMVC02/test
	 * @RequestMapping:可以加载方法上，也可以加载类上，
	 * 若类和方法上都加的有，应该一层一层的访问，先访问类，在访问类中的方法
	 * @RequestMapping:设置请求映射，把请求和控制层中的方法设置映射关系
	 * 当请求路径和@RequestMapping中的value属性值一致时，则改注解所标注的方法即为处理请求的方法
	 * method:用来设置请求方式，只有客户端发送请求的方式和method的值一致，才能处理请求
	 * 请求方式：GRT查询 PUT修改 POST添加DELETE删除
	 * params:用来设置客户端传到服务器端的数据，支持表达式
	 * username|username  username=admin username != admin
	 * headers:用来设置请求头信息，所发送的请求的请求头信息一定要和headers属性中所设置的一致
	 *
	 * @return
	 */
	@RequestMapping(value="/test",
			/*method=RequestMethod.POST,
			params={"username","age!= 12"}*/
			headers={"zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2"}
			)
	public String test() {
		System.out.println("SUCCESS.POST");
		return "success";
	}
	
	/*@RequestMapping(value="/test",method=RequestMethod.GET)
	public String testGET() {
		System.out.println("SUCCESS.GET");
		return "success";
	}*/
	
	/**
	 * springMVC支持Ant方式的请求路径
	 * 在Ant中，有三种匹配符
	 * *：任意字符
	 * ?：任意一个字符
	 * **：任意多层目录
	 */
	@RequestMapping(value="/*/ant??/**/testAnt")
	public String testAnt() {
		System.out.println("SUCCESSAnt");
		return "success";
	}
	
	/**
	 * 以前：localhost:8080/SpringMVC02/testREST?id=100&username=admin
	 * 现在：localhost:8080/SpringMVC02/testREST/100/admin
	 * @return
	 */
	@RequestMapping(value="/testREST/{id}/{username}")
	public String testREST(@PathVariable("id")Integer id,@PathVariable("username")String username) {
		System.out.println("id:"+id+",username:"+username);
		return "success";
	}
	
}

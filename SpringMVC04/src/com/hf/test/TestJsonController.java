package com.hf.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestJsonController {
	
	/**
	 * springMVC处理Json
	 * @responseBody
	 * @return
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public String testJson(){
		return "success";
	}
	
}

package com.hf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RESTController {
	
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.GET)
	public String  testREST(@PathVariable("id")Integer id) {
		System.out.println("GET:id: "+id);
		return "success";
	}
	
	@RequestMapping(value="/testREST",method=RequestMethod.POST)
	public String  insertUser() {
		System.out.println("POST: ");
		return "success";
	}
	
	@RequestMapping(value="/testREST",method=RequestMethod.PUT)
	public String  updateUser() {
		System.out.println("PUT: ");
		return "redirect:/tosuccess";
	}
	
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.DELETE)
	public String  deleteUser(@PathVariable("id")Integer id) {
		System.out.println("DELETE: ID :"+id);
		return "redirect:/tosuccess";
	}
	
	@RequestMapping(value="testAjax_DELETE",method=RequestMethod.DELETE)
	public void  testAjax_DELETE(Integer id) {
		System.out.println("testAjax_DELETE:id=="+id);
	}
	
	@RequestMapping(value="/tosuccess")
	public String  toSuccess() {
		return "success";
	}
	
}

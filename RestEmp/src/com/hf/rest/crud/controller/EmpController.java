package com.hf.rest.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hf.rest.crud.bean.Department;
import com.hf.rest.crud.bean.Employee;
import com.hf.rest.crud.dao.DepartmentDao;
import com.hf.rest.crud.dao.EmployeeDao;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping(value="/emps")
	public String getAll(Map<String, Object> maps) {
		Collection<Employee> emps = employeeDao.getAll();
		maps.put("emps", emps);
		return "list";
	}
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String toAdd(Map<String, Object> maps) {
		//获取所有部门信息
		Collection<Department> depts = departmentDao.getDepartments();
		//创建存储性别gender的信息
		HashMap<String, String> genders = new HashMap<>();
		genders.put("0", "女");
		genders.put("1", "男");
		maps.put("depts", depts);
		maps.put("genders", genders);
		//form标签有自动回显的功能，会在页面中能够默认获取request作用域中command属性的值
		//maps.put("command", new Employee());
		//若在<form:form>设置了modelAttribute，就可以自定义回显对象的属性名
		maps.put("emp", new Employee());
		return "edit";
	}
	
	@RequestMapping(value="/emp",method= RequestMethod.POST)
	public String addEmp(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * 获取要回显的数据，跳转到修改的页面，并回显
	 */
	@RequestMapping(value="/emp/{id}",method= RequestMethod.GET)
	public String toUpdate(@PathVariable("id") Integer id,Map<String, Object> maps) {
		//获取要修改的员工信息
		Employee emp = employeeDao.get(id);
		//所有的部门信息，供用户选择
		Collection<Department> depts = departmentDao.getDepartments();
		//设置存储性别的map集合
		HashMap<String, String> genders = new HashMap<>();
		genders.put("0", "女");
		genders.put("1", "男");
		maps.put("emp", emp);
		maps.put("depts", depts);
		maps.put("genders", genders);
		return "edit";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String  update(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	
}

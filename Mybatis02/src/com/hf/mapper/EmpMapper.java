package com.hf.mapper;

import java.util.List;

import com.hf.bean.Emp;

public interface EmpMapper {
	
	// 查询用户信息  通过用户id
	Emp getEmpByEid(String eid);
	// 查询所有用户信息
	List<Emp> getAllEmp();
	// 添加员工信息
	void addEmp(Emp emp);
	//删除用户信息
	Boolean deleteEmp(int i);
	//修改用户信息
	Boolean updateEmp(Emp emp);
	
}

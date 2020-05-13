package com.hf.ssm.mapper;

import java.util.List;

import com.hf.ssm.bean.Emp;

public interface EmpMapper {
	
	//获取所有员工
	List<Emp> getAllEmp();
	
	//通过eid获取员工信息
	Emp getEmpByEid(String eid);
	
	//修改员工信息
	void updateEmp(Emp emp);
}	

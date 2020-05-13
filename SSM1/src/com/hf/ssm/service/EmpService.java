package com.hf.ssm.service;

import java.util.List;

import com.hf.ssm.bean.Emp;

public interface EmpService {
	
	//获取所有员工
	List<Emp> getAllEmp();
	
	//通过eid获取员工信息
	Emp getEmpByEid(String eid);
	
	//修改员工信息
	void updateEmp(Emp emp);
}

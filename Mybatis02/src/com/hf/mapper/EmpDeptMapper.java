package com.hf.mapper;

import java.util.List;

import com.hf.bean.Dept;
import com.hf.bean.Emp;

public interface EmpDeptMapper {
	
	//查询所有员工信息
	List<Emp> getAllEmp();
	//
	Emp getEmpStep(String eid);
	
	Dept  getDeptEmpsByDid(String did);
	
	Dept getOnlyDeptByDid(String did);
	
	List<Emp> getEmpListByDid(String did);
}

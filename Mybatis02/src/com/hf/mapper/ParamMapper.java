package com.hf.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hf.bean.Emp;

public interface ParamMapper {
	
	// 添加员工号信息
	void insertEmp(Emp emp);
	
	//通过eid获取员工信息
	Emp getEmpByEid(String eid);
	
	//通过eid和ename查询员工信息
	Emp getEmpByEidAndEname(String eid, String ename);
	
	//以map集合查询员工信息
	Emp getEmpByMap(Map<String, Object> map);
	
	//根据eid和ename查询员工信息
	Emp getEmpByEidAndEnameByMap(@Param("eid")String eid, @Param("ename")String ename);
}

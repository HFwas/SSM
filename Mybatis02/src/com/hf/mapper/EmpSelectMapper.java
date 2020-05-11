package com.hf.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.hf.bean.Emp;

public interface EmpSelectMapper {
	//根据用户id查询用户信息
	Emp getEmpByEid(String eid);
	//获取所有员工数量
	Integer getCount();
	//以map集合获取一个员工信息
	Map<String, Object> getEmpMapByEid(String eid);
	//以map集合获取所有员工信息
	@MapKey("eid")  //设置map的键，因为在查询时传出所有员工信息，可以吧员工信息作为值，但是必须设置键
	Map<String, Object> getAllEmpMap();
}

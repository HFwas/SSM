package com.hf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hf.bean.Emp;

public interface EmpMapper {
	
	//查询所有
	List<Emp> getAllEmp();
	//根据eid,ename,age,sex多条件查询员工
	List<Emp> getEmpListByMoreTJ(Emp emp);
	////根据eid,ename,age,sex其中一个查询
	List<Emp> getEmpByChoose(Emp emp);
	//添加员工信息，将0|1--->女|男
	void insertEmp(Emp emp);
	//通过eid组成的字符窜实现批量删除
	void deleteMoreEmp(String eids);
	//通过list集合实现批量删除
	void deleteMoreByList(@Param("eids")List<Integer> eids);
	//批量添加数据
	void insertMoreByArray(@Param("emps")Emp[] emps);
	//批量修改 通过数组
	void updateMoreByArray(@Param("emps")Emp[] emps);
	
}

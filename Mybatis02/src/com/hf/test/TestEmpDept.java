package com.hf.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hf.bean.Dept;
import com.hf.bean.Emp;
import com.hf.mapper.EmpDeptMapper;

public class TestEmpDept {
	
	@Test
	public void TestEmpDept() throws Exception {
		
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession openSession = sessionFactory.openSession(true);//自动处理事务
		
		EmpDeptMapper mapper = openSession.getMapper(EmpDeptMapper.class);
		List<Emp> emp = mapper.getAllEmp(); 
		System.out.println(emp);
		/*Emp emp = mapper.getEmpStep("1"); 
		 * System.out.println(emp.getEname());
		 * System.out.println("=============="); 
	 	 * System.out.println(emp.getDept());*/
		/*Dept dept = mapper.getDeptEmpsByDid("1"); 
		 * System.out.println(dept);*/
		/*Dept dept = mapper.getOnlyDeptByDid("1");
		System.out.println(dept);*/
	}
}

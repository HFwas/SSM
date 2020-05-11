package com.hf.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hf.bean.Emp;
import com.hf.mapper.EmpMapper;

public class TestCRUD {
	@Test
	public void TestCRUD() throws Exception {
		
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//SqlSession openSession = sqlSessionFactory.openSession(); //需要手动处理事务
		SqlSession openSession = sqlSessionFactory.openSession(true); //自动处理事务
		EmpMapper mapper = openSession.getMapper(EmpMapper.class);
		
		//测试通过用户id查询用户
		/*Emp emp = mapper.getEmpByEid("2"); 
		System.out.println(emp);*/
		 
		//测试查询用户所有信息
		 /* List<Emp> list = mapper.getAllEmp(); 
		 * for (Emp emp : list) {
		 * System.out.println(emp); }
		 */
		/*
		 * 添加员工信息
		 *  mapper.addEmp(new Emp(null,"admin",28,"女")); 
		 * openSession.commit();
		 */
		//修改用户信息
		/* mapper.updateEmp(new Emp(1, "张三三", 33, "女")); */
		//删除用户信息
		/* mapper.deleteEmp("8"); */
		/*Boolean boolean1 = mapper.deleteEmp(8);
		System.out.println("resulte:"+boolean1);*/
	}
}

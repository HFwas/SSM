package com.hf.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hf.bean.Emp;
import com.hf.mapper.EmpMapper;

public class TestSQL {
	
	@Test
	public void updateMore() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp1 = new Emp(13, "a5", 15, "男");
		Emp emp2= new Emp(14, "aa5", 15, "男");
		Emp emp3 = new Emp(15, "aaa5", 15, "男");
		Emp[] emps = {emp1,emp2,emp3};
		mapper.updateMoreByArray(emps);
		
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(9);
		mapper.deleteMoreByList(list);*/
	}
	
	@Test
	public void testDeleteMore() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp1 = new Emp(null, "a", 15, "男");
		Emp emp2= new Emp(null, "aa", 15, "男");
		Emp emp3 = new Emp(null, "aaa", 15, "男");
		Emp[] emps = {emp1,emp2,emp3};
		mapper.insertMoreByArray(emps);
		
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(9);
		mapper.deleteMoreByList(list);*/
	}
	
	@Test
	public void testDelete() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		String eids= "10,11,12";
		mapper.deleteMoreEmp(eids);
	}
	
	@Test
	public void testInsert() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp  = new Emp();
		//emp.setEid(1);
		emp.setEname("张三");
		emp.setSex("1");
		//emp.setAge(28);
		mapper.insertEmp(emp);
	}
	
	@Test
	public void testChoose() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp  = new Emp();
		//emp.setEid(1);
		emp.setEname("张三");
		emp.setSex("1");
		//emp.setAge(28);
		List<Emp> list = mapper.getEmpByChoose(emp);
		for (Emp emp2 : list) {
			System.out.println(emp2);
		}
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}

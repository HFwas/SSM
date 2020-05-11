package com.hf.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hf.bean.Emp;
import com.hf.mapper.ParamMapper;

public class TestParam {
	@Test
	public void TestParam() throws Exception {
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//SqlSession openSession = sqlSessionFactory.openSession(); //需要手动处理事务
		SqlSession openSession = sqlSessionFactory.openSession(true); //自动处理事务
		ParamMapper mapper = openSession.getMapper(ParamMapper.class);
		
		/*Emp emp =new Emp(null, "张楠", 18, "女"); 
		 * paramMapper.insertEmp(emp);
		 * System.out.println(emp.getEid());*/
		
		/*Emp emp = mapper.getEmpByEid("2"); 
		 * System.out.println(emp);*/
		/* Emp emp = mapper.getEmpByEidAndEname("2", "李四"); 
		 * System.out.println(emp);*/
		
		/*Map<String , Object> map = new HashMap<String, Object>(); 
		 * map.put("eid","2");
		 * map.put("ename", "李四"); 
		 * Emp emp = mapper.getEmpByMap(map);*/
		Emp emp = mapper.getEmpByEidAndEnameByMap("2", "李四");
		System.out.println(emp);
	}
}

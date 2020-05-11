package com.hf.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hf.mapper.EmpSelectMapper;

public class TestSelct {
	@Test
	public void TestSelect() throws Exception {

		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession openSession = sessionFactory.openSession(true);
		EmpSelectMapper mapper = openSession.getMapper(EmpSelectMapper.class);
	
		/** Integer count = mapper.getCount(); 
		 * System.out.println("count:"+count); */

		/** Emp empByEid = mapper.getEmpByEid("3"); 
		 * System.out.println(empByEid);*/
		 
		// 以map获取单个map
		/** Map<String, Object> map = mapper.getEmpMapByEid("3");
		 * System.out.println(map);*/
		 
		// 以map获取所有emo
		
		/*
		 * Map<String, Object> allEmpMap = mapper.getAllEmpMap();
		 * System.out.println(allEmpMap);
		 */
		 
	}
}

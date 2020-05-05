package com.hf.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hf.bean.User;

public class TestMyBatis {
	
	@Test
	public void testMyBatis() throws IOException{
		
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-conf.xml");
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//getMapper():会通过动态代理动态生成UserMapper的代理实现类
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(mapper.getClass().getName());
		User user = mapper.getUserByUid("1");
		System.out.println(user);
	}
}

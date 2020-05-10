package com.framework.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBFactory {
	// 1、定义静态常量
	private static SqlSessionFactory sqlSessionFactory = null;
	// 2、静态快取到sqlSessionFactory
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3、获取SqlSession
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}

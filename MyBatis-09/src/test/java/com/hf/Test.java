package com.hf;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.framework.utils.DBFactory;
import com.hf.model.system.User;

public class Test {

	public static void main(String[] args) throws IOException {
		// 从mybatis-config.xml中创建SqlSessionFactory
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader, "mysql");
		// 获取SqlSession
		SqlSession sqlSession = ssf.openSession();
		// 操作数据库：通过命名空间查询SQL
		// ########################业务###########################
		User user = sqlSession.selectOne("com.hf.mapper.system.User.queryUserByUserId", 1);
		System.out.println("--------------" + user);
		// ########################业务###########################

	}

	@org.junit.Test
	public void queryUserByName() throws IOException {
		// 从mybatis-config.xml中创建SqlSessionFactory
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader, "mysql");
		// 获取SqlSession
		SqlSession sqlSession = ssf.openSession();
		// 操作数据库：通过命名空间查询SQL
		// ########################业务###########################
		User user = sqlSession.selectOne("com.hf.mapper.system.User.queryUserByName", "小翠翠");
		System.out.println("--------------" + user);
		// ########################业务###########################
	}

	@org.junit.Test
	public void queryAllUser() throws IOException {
		// 从mybatis-config.xml中创建SqlSessionFactory
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader, "mysql");
		// 获取SqlSession
		SqlSession sqlSession = ssf.openSession();
		// 操作数据库：通过命名空间查询SQL
		// ########################业务###########################

		List<User> UserList = sqlSession.selectList("com.hf.mapper.system.User.queryAllUser");
		for (User user2 : UserList) {
			System.out.println("--------------" + user2);
		}

		// ########################业务###########################
	}

	@org.junit.Test
	public void queryAllUser2() throws IOException {
		// ########################业务###########################
		// 获取SqlSession
		SqlSession sqlSession = DBFactory.getSqlSession();
		List<User> UserList = sqlSession.selectList("com.hf.mapper.system.User.queryAllUser");
		for (User user2 : UserList) {
			System.out.println("--------------" + user2);
		}
		// ########################业务###########################
	}
}

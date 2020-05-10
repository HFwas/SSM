package com.hf.service.system.impl;

import org.apache.ibatis.session.SqlSession;

import com.framework.utils.DBFactory;
import com.hf.dao.system.UserMapper;
import com.hf.model.system.User;
import com.hf.service.system.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User queryUserByLoginNameAndPssword(User user) {
		SqlSession sqlSession=null;
		try {
			sqlSession = DBFactory.getSqlSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			User user_db= mapper.queryUserByLoginNameAndPssword(user);
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			sqlSession.rollback();
		}finally {
			//关闭事务
			sqlSession.close();
		}
		return null;
	}
	
	
}

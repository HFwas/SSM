package com.hf;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.framework.utils.DBFactory;
import com.hf.dao.system.UserMapper;
import com.hf.model.system.User;

public class testUserMapper {
	
	@Test
	public void addUser(){
		SqlSession sqlSession=null;
		try {
			sqlSession = DBFactory.getSqlSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			User user=new User();
			user.setName("刘子");
			user.setLoginName("lz");
			user.setPassword("156");
			user.setSalt("225");
			user.setLocked("起用");
			user.setCreateTime("2020-04-03");
			
			int addUser = mapper.addUser(user);
			if (addUser > 0) {
				System.err.println("======添加成功====");
			}else {
				System.err.println("===添加失败===");
			}
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
	}
	
	@Test
	public void deleteUser(){
		SqlSession sqlSession=null;
		try {
			sqlSession = DBFactory.getSqlSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			int userId=7;
			int addUser = mapper.deleteUser(userId);
			if (addUser > 0) {
				System.err.println("======删除成功====");
			}else {
				System.err.println("===删除失败===");
			}
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
	}
	
	@Test
	public void updateUser(){
		SqlSession sqlSession=null;
		try {
			sqlSession = DBFactory.getSqlSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			User user = new User();
			user.setUserId(1);
			user.setName("张三");
			user.setLoginName("zs");
			user.setPassword("456");
			int n = mapper.updateUser(user);
			if (n > 0) {
				System.err.println("======修改成功====");
			}else {
				System.err.println("===修改失败===");
			}
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
	}
	
	@Test
	public void queryUserByUserId(){
		SqlSession sqlSession=null;
		try {
			sqlSession = DBFactory.getSqlSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			int userId =4;
			User user = mapper.queryUserByUserId(userId);
			System.out.println("======"+user);
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
	}
	
	@Test
	public void queryAllUser(){
		SqlSession sqlSession=null;
		try {
			sqlSession = DBFactory.getSqlSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			List<User> userList = mapper.queryAllUser();
			for (User user : userList) {
				System.out.println("====="+user);
			}
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
	}
}

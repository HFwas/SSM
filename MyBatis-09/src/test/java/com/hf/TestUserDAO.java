/*package com.hf;

import java.util.List;

import com.hf.dao.system.UserMapper;
import com.hf.dao.system.impl.UserDaoImp;
import com.hf.model.system.User;

public class TestUserDAO {
	// 实例化Dao接口
	UserMapper userDao = new UserDaoImp();

	@org.junit.Test
	public void deleteUser() {
		// 初始化数据
		int userId = 5;
		// 调用Dao接口
		int m = userDao.deleteUser(userId);
		System.out.println("---------------------" + m);

	}

	@org.junit.Test
	public void addUser() {
		// 初始化数据
		User user = new User();
		user.setName("小三");
		user.setLoginName("xs");
		user.setPassword("156");
		user.setSalt("225");
		user.setLocked("起用");
		user.setCreateTime("2020-04-03");

		// 调用Dao接口
		int m = userDao.addUser(user);
		System.out.println("---------------------" + m);

	}

	@org.junit.Test
	public void updateUser() {
		// 初始化数据
		User user = new User();
		user.setUserId(1);
		user.setName("张三三");
		user.setLoginName("zs");
		user.setPassword("111");
		user.setSalt("456");
		user.setLocked("起用");
		user.setCreateTime("2020-04-03");

		// 调用Dao接口
		int m = userDao.updateUser(user);
		System.out.println("---------------------" + m);

	}

	@org.junit.Test
	public void queryAllUser() {
		// 初始化数据
		// 调用Dao接口
		List<User> userList = userDao.queryAllUser();
		for (User user : userList) {
			System.err.println("---------------------" + user);
		}

	}

	@org.junit.Test
	public void queryUserByUserId() {
		// 初始化数据
		int userId = 1;
		// 调用Dao接口
		User user = userDao.queryUserByUserId(userId);
		System.err.println("---------------------" + user);

	}
}
*/
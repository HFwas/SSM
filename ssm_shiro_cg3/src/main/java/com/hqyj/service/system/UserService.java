package com.hqyj.service.system;

import java.util.List;

import com.hqyj.model.system.User;

public interface UserService {

	User queryUserByUsernameAndPassword(User user);

	List<User> queryAllUser();

	int addUserByUser(User user);

	int deleteUserByUserId(int userId);

	User queryUserByUserId(int userId);

	int updateUserByUser(User user);

}

package com.hf.service.system;

import com.hf.model.system.User;

public interface UserService {
	
	public User queryUserByLoginNameAndPssword(User user);

}

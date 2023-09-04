package com.app.service;

import java.util.List;

import com.app.pojo.User;

public interface UserService {

	User saveUser(User user);
	List<User> getAllUser();
	User getUserById(int userId);
}

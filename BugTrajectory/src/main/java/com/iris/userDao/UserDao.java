package com.iris.userDao;

import java.util.List;

import com.iris.model.User;



public interface UserDao {
	public User validateUser(String email,String password);
	public List<User> getAllDev();
	public List<User> getAllTest();
	public User getUserById(int userId);
	
}

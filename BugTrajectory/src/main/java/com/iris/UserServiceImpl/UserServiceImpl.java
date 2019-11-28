package com.iris.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.UserService.UserService;
import com.iris.model.User;
import com.iris.userDao.UserDao;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
		public User validateUser(String email, String password) {
			try {
				return userDao.validateUser(email,password);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}
		
		public List<User> getAllDev() {
			try {
				return userDao.getAllDev();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		public List<User> getAllTest() {
			try {
				return userDao.getAllTest();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}

		public User getUserById(int userId) {
			return userDao.getUserById(userId);
		}

}

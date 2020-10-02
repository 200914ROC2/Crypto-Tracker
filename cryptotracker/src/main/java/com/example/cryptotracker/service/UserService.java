package com.example.cryptotracker.service;

import com.example.cryptotracker.dao.UserDao;
import com.example.cryptotracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private final UserDao userDao;

	@Autowired
	public UserService(@Qualifier("userDao") UserDao userDao) {
		this.userDao = userDao;
	}

	public User addUser(User user) {
		return userDao.insertUser(user);
	}

	public User getUser(User user) {
		return userDao.getUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public List<String> getUserPortfolio(User user) {
		return userDao.getPortfolio(user);
	}

	public void addToPortfolio(User user, String cryptocurrency) {
		userDao.addToPortfolio(user, cryptocurrency);
	}

	public List<String> removeFromPortfolio(User user, String cryptocurrency) {
		return userDao.removeFromPortfolio(user, cryptocurrency);
	}

}

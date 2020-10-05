package com.example.cryptotracker.service;

import com.example.cryptotracker.dao.UserDao;
import com.example.cryptotracker.model.User;
import com.example.cryptotracker.security.PasswordHasher;
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
		user.setPassword(PasswordHasher.generateHash(user.getPassword()));
		return userDao.insertUser(user);
	}

	public User getUser(User user) {
		String hashedPass = userDao.getPassword(user.getUsername());
		user.setPassword(PasswordHasher.getHashed(user.getPassword(),hashedPass));
		return userDao.getUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public List<String> getUserPortfolio(User user) {
		return userDao.getPortfolio(user);
	}

	public void addToPortfolio(User user, String symbol) {
		userDao.addToPortfolio(user, symbol);
	}

	public void removeFromPortfolio(User user, String symbol) {
		userDao.removeFromPortfolio(user, symbol);
	}

}

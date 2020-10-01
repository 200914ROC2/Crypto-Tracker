package com.example.cryptotracker.service;

import com.example.cryptotracker.dao.UserDao;
import com.example.cryptotracker.model.Crypto;
import com.example.cryptotracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	public List<Crypto> getUserPortfolio(User user) {
		return userDao.getPortfolio(user);
	}

	public List<Crypto> addToPortfolio(User user, Crypto cryptocurrency) {
		return userDao.addToPortfolio(user, cryptocurrency);
	}

	public List<Crypto> removeFromPortfolio(User user, Crypto cryptocurrency) {
		return userDao.removeFromPortfolio(user, cryptocurrency);
	}

	public List<String> getAllPortfolios() {
		return userDao.getAltPortfolio();
	}

}

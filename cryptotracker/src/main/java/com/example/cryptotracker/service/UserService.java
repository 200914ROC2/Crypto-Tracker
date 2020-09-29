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

    public User addUser(User user){
        return userDao.insertUser(user);
    }

    public Optional<User> getUser(String username, String password) {
    	return userDao.getUser(username, password);
    }
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

	public List<Crypto> getUserPortfolio() {
		return UserDao.getUserPortfolio;
	}

	public List<Crypto> addToPortfolio() {
		return userDao.addToPortfolio();
	}

	public List<Crypto> removeFromPortfolio() {
		return userDao.removeFromPortfolio();
	}
}

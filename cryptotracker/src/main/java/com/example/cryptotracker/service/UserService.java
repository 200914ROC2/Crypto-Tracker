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
    public UserService(@Qualifier("userdao") UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user){
        return userDao.insertUser(user);
    }
    
    public User updateUser(User user) {
    	return userDao.updateUser(user);
    }

    public User getUser(String username, String password) {
    	return userDao.getUser(username, password);
    }
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}

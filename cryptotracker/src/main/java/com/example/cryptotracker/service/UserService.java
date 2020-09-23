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
    public UserService(@Qualifier("fakeDao") UserDao personDao) {
        this.userDao = personDao;
    }

    public int addUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
}

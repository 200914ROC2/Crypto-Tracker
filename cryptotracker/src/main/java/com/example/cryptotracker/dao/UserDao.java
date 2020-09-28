package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.User;

import java.util.List;
import java.util.UUID;
//Temporary
public interface UserDao {

    User insertUser(User user);

    User updateUser(User user);
    
    User getUser(String username, String password);

    List<User> getAllUsers();
    
    
    
}

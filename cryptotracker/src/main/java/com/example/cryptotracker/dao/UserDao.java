package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.User;

import java.util.List;
import java.util.UUID;
//Temporary
public interface UserDao {


    int insertUser(User user);

    List<User> getAllUser();
}

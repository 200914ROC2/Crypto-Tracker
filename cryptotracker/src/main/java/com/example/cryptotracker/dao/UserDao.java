package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {


    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id,user);
    }

    List<User> getAllUser();
}

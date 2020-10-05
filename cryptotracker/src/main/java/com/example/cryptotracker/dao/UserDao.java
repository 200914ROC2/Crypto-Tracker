package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.User;

import java.util.List;

//Temporary
public interface UserDao {

	User insertUser(User user);
        
    User getUser(User user);

    String getPassword(String username);

    List<User> getAllUsers();
    
    List<String> getPortfolio(User user);

	void addToPortfolio(User user, String symbol);

	void removeFromPortfolio(User user, String symbol);
    
}

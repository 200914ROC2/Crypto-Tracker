package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.Crypto;
import com.example.cryptotracker.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//Temporary
public interface UserDao {

	User insertUser(User user);
        
    User getUser(User user);

    List<User> getAllUsers();
    
    List<String> getPortfolio(User user);

	List<String> addToPortfolio(User user, String cryptocurrency);

	List<String> removeFromPortfolio(User user, String cryptocurrency);

	List<String> getUserStringPortfolio(User user);    
    
    
}

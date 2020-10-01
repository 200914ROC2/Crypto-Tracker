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
    
    List<Crypto> getPortfolio(User user);

	List<Crypto> addToPortfolio(User user, Crypto cryptocurrency);

	List<Crypto> removeFromPortfolio(User user, Crypto cryptocurrency);

	List<String> getUserStringPortfolio(User user);    
    
    
}

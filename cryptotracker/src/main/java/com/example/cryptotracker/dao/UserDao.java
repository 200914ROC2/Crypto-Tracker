package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.Crypto;
import com.example.cryptotracker.model.User;

import java.util.List;
import java.util.UUID;
//Temporary
public interface UserDao {

    List<Crypto> getUserPortfolio = null;

	User insertUser(User user);

    User updateUser(User user);
    
    void updateUserPortfolio();
    
    User getUser(String username, String password);

    List<User> getAllUsers();

	List<Crypto> addToPortfolio();

	List<Crypto> removeFromPortfolio();
    
    
    
}

package com.example.cryptotracker.dao;

import com.example.cryptotracker.model.Crypto;
import com.example.cryptotracker.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//Temporary
public interface UserDao {

    List<Crypto> getUserPortfolio = null;

	User insertUser(User user);

    User updateUser(User user);
        
    Optional<User> getUser(String username, String password);

    List<User> getAllUsers();
    
    List<Crypto> getPortfolio(String username, String password);

	List<Crypto> addToPortfolio();

	List<Crypto> removeFromPortfolio();
    
    
    
}

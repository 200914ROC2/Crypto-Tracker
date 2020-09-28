package com.example.cryptotracker.api;

import com.example.cryptotracker.model.User;
import com.example.cryptotracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

//Temporary
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/register")
    public void addUser(@Valid @NotNull @RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/api/get")//for testing
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
}

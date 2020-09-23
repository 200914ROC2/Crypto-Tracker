package com.example.cryptotracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private final String username;
    private String password;
    private String email;

    private List<Crypto> portfolio;

    public User(@JsonProperty("id") int id,
                @JsonProperty("username") String name,
                @JsonProperty("password") String password,
                @JsonProperty("email") String email) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.email = email;
        portfolio = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPortfolio(List<Crypto> portfolio) {
        this.portfolio = portfolio;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void addToPortfolio(Crypto crypto){
        portfolio.add(crypto);
    }

    public List<Crypto> getPortfolio() {
        return portfolio;
    }

    public String getUsername() {
        return username;
    }
}

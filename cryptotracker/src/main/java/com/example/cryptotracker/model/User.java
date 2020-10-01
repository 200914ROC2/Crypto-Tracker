package com.example.cryptotracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;

    @NotBlank
    private final String username;

    @NotBlank
    private String password;

    private String email;

    private List<String> portfolio;

    public User(@JsonProperty("id") int id,
                @JsonProperty("username") String name,
                @JsonProperty("password") String password,
                @JsonProperty("email") String email) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.email = email;
        this.portfolio = new ArrayList<>();
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

    public void setPortfolio(List<String> portfolio) {
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

    public void addToPortfolio(String cryptocurrency){
        portfolio.add(cryptocurrency);
    }

    public List<String> getPortfolio() {
        return portfolio;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", portfolio=" + portfolio +
                '}';
    }
}

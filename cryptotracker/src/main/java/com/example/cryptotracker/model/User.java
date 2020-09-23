package com.example.cryptotracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    private final UUID id;

    private final String username;

    public User(@JsonProperty("id") UUID id,
                  @JsonProperty("username") String name) {
        this.id = id;
        this.username = name;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}

package com.example.cryptotracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//AKA Portfolio
public class Crypto {

    int id;
    String symbol;

    public Crypto(@JsonProperty("id") int id,
                  @JsonProperty("symbol") String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }
}

package com.example.cryptotracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

//AKA Portfolio
public class Crypto {

  
    @NotBlank
    String symbol;

    public Crypto(@JsonProperty("symbol") String symbol) {
        this.symbol = symbol;
    }

 
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

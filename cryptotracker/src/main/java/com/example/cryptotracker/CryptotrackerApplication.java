package com.example.cryptotracker;

import com.example.cryptotracker.security.PasswordHasher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptotrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptotrackerApplication.class, args);
	}

}

package com.example.cryptotracker.api;

import com.example.cryptotracker.model.Crypto;
import com.example.cryptotracker.model.User;
import com.example.cryptotracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/// api/register Post { "username", "password", "email" } returns {"username"}
	@PostMapping("/api/register")
	public User addUser(@Valid @NotNull @RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/api/get") // for testing
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}
	@PostMapping("/api/getUserStringPortfolio")
	public List<String> getUserStringPortfolio(@RequestBody User user){
		return userService.getUserStringPortfolio(user);
	}
	
	//after session make this a getmapping instead, and get user info from session.
	// api/portfolio Get returns [{"symbol"}, ...]
	@PostMapping("/api/portfolio")
	public List<String> getUserPortfolio(@RequestBody User user) {
		return userService.getUserPortfolio(user);
	}

	// api/portfolio/add Post {"symbol"}
	@PostMapping("/api/portfolio/add")
	public void addToPortfolio(@Valid @NotNull @RequestBody User user, @Valid @NotNull @RequestBody String cryptocurrency) {
		userService.addToPortfolio(user, cryptocurrency);
	}

	// api/portfolio/remove Delete {"symbol"}
	@DeleteMapping("api/portfolio/remove")
	public List<String> removeFromPortfolio(@Valid @NotNull @RequestBody User user, @Valid @NotNull @RequestBody String cryptocurrency) {
		return userService.removeFromPortfolio(user, cryptocurrency);
	}

	// api/login Post {"username", "password"} returns {"username"}
	@PostMapping("/api/login")
	public User getUser(@Valid @NotNull @RequestBody User user) {
		System.out.println(user);
		return userService.getUser(user);
	}

	// still need methds for:
	// api/logout Get

}

package com.example.cryptotracker.api;

import com.example.cryptotracker.model.User;
import com.example.cryptotracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/// api/register Post { "username", "password", "email" } returns {"username"}
	@PostMapping("/register")
	public User addUser(@Valid @NotNull @RequestBody User user, Model model) {
		return userService.addUser(user);
	}

	@GetMapping("/get") // for testing
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}
	
	//after session make this a getmapping instead, and get user info from session.
	// api/portfolio Get returns [{"symbol"}, ...]
	@GetMapping("/portfolio")
	public List<String> getUserPortfolio(HttpSession session) {
		User user = (User)session.getAttribute("user");
		return userService.getUserPortfolio(user);
	}

	// api/portfolio/add Post {"symbol"}
	@PostMapping("/portfolio/add")
	public void addToPortfolio(HttpSession session, @RequestParam("symbol") String symbol) {
		User user = (User)session.getAttribute("user");
		userService.addToPortfolio(user, symbol);
	}

	// api/portfolio/remove Delete {"symbol"}
	@DeleteMapping("/portfolio/remove")
	public void removeFromPortfolio(HttpSession session, @RequestParam("symbol") String symbol) {
		User user = (User)session.getAttribute("user");
		userService.removeFromPortfolio(user, symbol);
	}

	// api/login Post {"username", "password"} returns {"username"}
	@PostMapping("/login")
	public User getUser(@Valid @NotNull @RequestBody User user, HttpSession session) {
		User loginUser = userService.getUser(user);
		if(loginUser != null){
			session.setAttribute("user",loginUser);
		}
		return loginUser;
	}

	@GetMapping("/logout")
	public void logout(HttpSession session){
		session.removeAttribute("user");
	}

}

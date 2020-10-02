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
	@PostMapping("/getUserStringPortfolio")
	public List<String> getUserStringPortfolio(@RequestBody User user){
		return userService.getUserStringPortfolio(user);
	}
	
	//after session make this a getmapping instead, and get user info from session.
	// api/portfolio Get returns [{"symbol"}, ...]
	@PostMapping("/portfolio")
	public List<String> getUserPortfolio(@RequestBody User user) {
		return userService.getUserPortfolio(user);
	}

	// api/portfolio/add Post {"symbol"}
	@PostMapping("/portfolio/add")
	public void addToPortfolio(@RequestParam("symbol") String cryptocurrency) {

	}

	// api/portfolio/remove Delete {"symbol"}
	@DeleteMapping("/portfolio/remove")
	public List<String> removeFromPortfolio(@RequestParam("symbol") String cryptocurrency,HttpSession session) {
		List<String> result = null;
		User user = (User)session.getAttribute("user");
		if(user != null){
			result = userService.removeFromPortfolio(user, cryptocurrency);
		}
		return result;
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
		System.out.println(session.getAttribute("user"));
	}

}

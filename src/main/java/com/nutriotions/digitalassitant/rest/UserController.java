package com.nutriotions.digitalassitant.rest;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.nutriotions.digitalassitant.model.User;
import com.nutriotions.digitalassitant.service.UserService;


@RestController
@RequestMapping()
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public User login(@RequestParam("email") String email, @RequestParam("password") String password) {
		return userService.findByEmail(email, password);
	}
	
	@GetMapping("/user/{id}")	
	public Optional<User> idUser(@PathVariable ("id") Integer id){
		return userService.getById(id);
	}
	
	@GetMapping("/users")
	public List<User> allUsers() {		 
		return userService.getAllUsers();
	}
	
	@PostMapping("/save/user")
	public User saveNewUser(@RequestBody User newUser) {
		return userService.saveUser(newUser);
	}
	

}

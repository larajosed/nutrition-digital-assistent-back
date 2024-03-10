package com.nutriotions.digitalassitant.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nutriotions.digitalassitant.model.Users;
import com.nutriotions.digitalassitant.service.UserService;


@RestController
@RequestMapping()
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public Users login(@RequestParam("email") String email, @RequestParam("password") String password) {
		return userService.findByEmail(email, password);
	}
	
	@GetMapping("/user/{id}")	
	public Optional<Users> idUser(@PathVariable ("id") Integer id){
		return userService.getById(id);
	}
	
	@GetMapping("/users")
	public List<Users> allUsers() {		 
		return userService.getAllUsers();
	}
}

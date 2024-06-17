package com.nutritions.digitalassistant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nutritions.digitalassistant.model.User;
import com.nutritions.digitalassistant.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User findByEmail(String email, String password) {
		User usuario = userRepository.findByEmail(email).orElse(null);
		if(usuario != null && password.equals(usuario.getPassword())) {
			 return usuario;
		 } else {
			 return null;
		 }		
	}

	public Optional<User> getById(Integer id) {
		return userRepository.findById(id);

	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User newUser) {
		return userRepository.save(newUser);
	}

	
}

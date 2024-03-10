package com.nutriotions.digitalassitant.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nutriotions.digitalassitant.model.Users;
import com.nutriotions.digitalassitant.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Users findByEmail(String email, String password) {
		Users usuario = userRepository.findByEmail(email).orElse(null);
		if(usuario != null && password.equals(usuario.getPassword())) {
			 return usuario;
		 } else {
			 return null;
		 }		
	}

	public Optional<Users> getById(Integer id) {
		return userRepository.findById(id);

	}

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
}

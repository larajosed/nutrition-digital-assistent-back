package com.nutriotions.digitalassitant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutriotions.digitalassitant.model.Location;
import com.nutriotions.digitalassitant.model.Province;
import com.nutriotions.digitalassitant.model.User;
import com.nutriotions.digitalassitant.repository.LocationRepository;
import com.nutriotions.digitalassitant.repository.ProvinceRepository;
import com.nutriotions.digitalassitant.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
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

	public List<Province> getAllProvinces() {
		return provinceRepository.findAll();
	}

	public List<Location> getAllLocationById(Integer idProvince) {
		List<Location> location = locationRepository.findAllLocationByIdProvince(idProvince);
		return location;
		
	}
}

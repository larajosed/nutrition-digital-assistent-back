package com.nutriotions.digitalassitant.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nutriotions.digitalassitant.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	Optional<User> findByid(Integer id);
	
	
}

package com.nutriotions.digitalassitant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutriotions.digitalassitant.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String email);
	Optional<Users> findByid(Integer id);
	
}

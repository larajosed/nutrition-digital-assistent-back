package com.nutritions.digitalassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritions.digitalassistant.model.Meal;

public interface MealsRepository extends JpaRepository<Meal, Integer> {
	List<Meal> findAll();
}

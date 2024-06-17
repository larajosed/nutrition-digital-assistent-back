package com.nutritions.digitalassistant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritions.digitalassistant.model.Recipe;



public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

	Page<Recipe> findAllByNameContaining(Pageable pageableConfig, String recipeName);
}

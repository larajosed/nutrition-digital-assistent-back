package com.nutritions.digitalassistant.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nutritions.digitalassistant.model.Planning;
import com.nutritions.digitalassistant.model.Recipe;



public interface PlanningRepository extends JpaRepository<Planning, Integer>{
	
	@Query(value = "Select * FROM PLANNING WHERE id_day = :idDay AND id_diet = :idDiet AND id_meal = :idMeal", nativeQuery = true)
	Planning getPlanning(@Param("idDay") Integer id, @Param("idDiet") Integer idDiet, @Param("idMeal") Integer idMeal);

	
}

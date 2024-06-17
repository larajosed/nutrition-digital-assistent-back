package com.nutritions.digitalassistant.repository;


import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nutritions.digitalassistant.model.Diet;

public interface DietRepository extends JpaRepository<Diet, Integer> {

	@Query(value = "Select * FROM DIETS WHERE id_user = :id ORDER BY date DESC LIMIT 1", nativeQuery = true)
	Diet getDietByUserId(@Param("id") Integer id);
	
	Diet getDietById(@Param("id") Integer id);
	
	Page<Diet> findAllByUser_NameContainingAndTypeIn(Pageable sortedByUserName, String userName, ArrayList<Integer> listType);
}

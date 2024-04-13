package com.nutritions.digitalassistant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.nutritions.digitalassistant.model.Diet;



public interface DietRepository extends JpaRepository <Diet, Integer> {

	Diet getDietsByidUser(Integer id);

}

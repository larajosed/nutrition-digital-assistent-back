package com.nutritions.digitalassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritions.digitalassistant.model.Day;

public interface DaysRepository extends JpaRepository<Day, Integer>{
	Day getDietById(Integer id);
	List<Day> findAll();
}

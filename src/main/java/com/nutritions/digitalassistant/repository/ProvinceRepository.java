package com.nutritions.digitalassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritions.digitalassistant.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	List<Province> findAll();
}

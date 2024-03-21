package com.nutriotions.digitalassitant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutriotions.digitalassitant.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	List<Province> findAll();
}

package com.nutriotions.digitalassitant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutriotions.digitalassitant.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{


	public List<Location> findAllLocationByIdProvince(Integer idProvince);

}

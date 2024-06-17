package com.nutritions.digitalassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritions.digitalassistant.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{


	public List<Location> findAllLocationByIdProvince(Integer idProvince);

}

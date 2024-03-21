package com.nutriotions.digitalassitant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutriotions.digitalassitant.model.Location;
import com.nutriotions.digitalassitant.model.Province;
import com.nutriotions.digitalassitant.repository.LocationRepository;
import com.nutriotions.digitalassitant.repository.ProvinceRepository;

@Service
public class MasterTablesService {

	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	public List<Province> getAllProvinces() {
		return provinceRepository.findAll();
	}

	public List<Location> getAllLocationById(Integer idProvince) {
		List<Location> location = locationRepository.findAllLocationByIdProvince(idProvince);
		return location;
		
	}
}

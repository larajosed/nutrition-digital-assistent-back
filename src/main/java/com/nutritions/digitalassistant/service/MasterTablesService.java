package com.nutritions.digitalassistant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritions.digitalassistant.model.Day;
import com.nutritions.digitalassistant.model.Location;
import com.nutritions.digitalassistant.model.Meal;
import com.nutritions.digitalassistant.model.Province;
import com.nutritions.digitalassistant.repository.DaysRepository;
import com.nutritions.digitalassistant.repository.LocationRepository;
import com.nutritions.digitalassistant.repository.MealsRepository;
import com.nutritions.digitalassistant.repository.ProvinceRepository;

@Service
public class MasterTablesService {

	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private DaysRepository daysRepository;
	
	@Autowired
	private MealsRepository mealsRepository;
	
	public List<Province> getAllProvinces() {
		return provinceRepository.findAll();
	}

	public List<Location> getAllLocationById(Integer idProvince) {
		List<Location> location = locationRepository.findAllLocationByIdProvince(idProvince);
		return location;
		
	}

	public List<Meal> getAllMeals() {
		List<Meal> meal = mealsRepository.findAll();
		return meal;
	}
	
	public List<Day> getAllDays() {
		List<Day> days = daysRepository.findAll();
		return days;
	}
}

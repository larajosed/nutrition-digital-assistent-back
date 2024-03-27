package com.nutritions.digitalassistant.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritions.digitalassistant.model.Location;
import com.nutritions.digitalassistant.model.Province;
import com.nutritions.digitalassistant.service.MasterTablesService;

@CrossOrigin
@RestController
@RequestMapping()
public class MasterTablesController {
	
	@Autowired
	MasterTablesService masterTablesService;
	
	@GetMapping("/provinces")
	public List<Province> allProvinces() {		 
		return masterTablesService.getAllProvinces();
	}
	
	@GetMapping("/location/{idProvince}")
	public List<Location> getAllLocation(@PathVariable ("idProvince") Integer idProvince){
		return masterTablesService.getAllLocationById(idProvince);
	}

}

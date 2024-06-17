package com.nutritions.digitalassistant.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritions.digitalassistant.model.MedicalData;
import com.nutritions.digitalassistant.service.MedicalDataService;

@CrossOrigin
@RestController
@RequestMapping()
public class MedicalDataController {
	@Autowired
	MedicalDataService medicalDataService;
	
	@GetMapping("medicalData/{idUser}")
	public MedicalData id(@PathVariable("idUser") Integer id) {
		return medicalDataService.getMedicalDataById(id);
	}
	
	

}

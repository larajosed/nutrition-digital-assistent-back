package com.nutritions.digitalassistant.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritions.digitalassistant.dto.MedicalDataDTO;
import com.nutritions.digitalassistant.model.Diet;
import com.nutritions.digitalassistant.service.DietService;
import com.nutritions.digitalassistant.service.MedicalDataService;

@CrossOrigin
@RestController
@RequestMapping()
public class DietController {
	
@Autowired
MedicalDataService medicalDataService;

@Autowired
DietService dietService;

@PostMapping("/save/diet")
public Diet saveNewMedicalData(@RequestBody MedicalDataDTO medicalDataDTO) {
	
	return dietService.saveDiet(medicalDataDTO);
}



}

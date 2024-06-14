package com.nutritions.digitalassistant.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritions.digitalassistant.dto.DayAndMealsDto;
import com.nutritions.digitalassistant.dto.MedicalDataDto;
import com.nutritions.digitalassistant.dto.SearchDto;
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
	public Diet saveNewMedicalData(@RequestBody MedicalDataDto medicalDataDto) {

		return dietService.saveDiet(medicalDataDto);
	}
	

	@GetMapping("/diet/user/{id}")
	public List<DayAndMealsDto> getDietByUserId(@PathVariable("id") Integer id) {
		return dietService.getDiet(id);
	}
	
	@PostMapping("/allDiets")
	public ResponseEntity<Page<Diet>> getAllDiets(@RequestBody SearchDto searchDto){	
		return ResponseEntity.ok(dietService.getAllDiets(searchDto));
	}
	
	@DeleteMapping("/delete/diet/{id}")
	  public void deleteDietById(@PathVariable("id") Integer id) {
	    dietService.deleteDietById(id);
	  }
	
	@GetMapping("/admin/viewer/diet/{id}")
	public List<DayAndMealsDto> getDiet(@PathVariable("id") Integer id) {
		return dietService.getDietById(id);
	}
	
}



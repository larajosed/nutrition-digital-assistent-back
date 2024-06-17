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

import com.nutritions.digitalassistant.dto.SearchDto;
import com.nutritions.digitalassistant.model.Planning;

import com.nutritions.digitalassistant.model.Recipe;
import com.nutritions.digitalassistant.service.PlanningService;


@CrossOrigin
@RestController
@RequestMapping()
public class PlanningController {
	
	@Autowired
	PlanningService planningService;
	
	
	@DeleteMapping("/recipe/delete/{idDiet}/{idDay}/{idMeal}/{idRecipe}")
	public void  deletePlanning(@PathVariable("idDay") Integer idDay, @PathVariable("idDiet") Integer idDiet,@PathVariable("idMeal") Integer idMeal, @PathVariable("idRecipe") Integer idRecipe) {
		 planningService.removeRecipe(idDay, idDiet, idMeal, idRecipe);
	}
	
	@PostMapping("/recipe/save/{idDiet}/{idDay}/{idMeal}/{idRecipe}")
	public void saveRecipe(@PathVariable("idDay") Integer idDay, @PathVariable("idDiet") Integer idDiet,@PathVariable("idMeal") Integer idMeal, @PathVariable("idRecipe") Integer idRecipe) {
		planningService.saveRecipeInPlanning(idDay, idDiet, idMeal, idRecipe);
	}
	
	@PostMapping("/allRecipes")
	public ResponseEntity<Page<Recipe>> getAllRecipes(@RequestBody SearchDto searchDto){	
		return ResponseEntity.ok(planningService.getAllRecipes(searchDto));
	}
	
}

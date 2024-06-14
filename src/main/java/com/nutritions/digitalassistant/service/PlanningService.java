package com.nutritions.digitalassistant.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nutritions.digitalassistant.dto.ConditionDto;
import com.nutritions.digitalassistant.dto.SearchDto;
import com.nutritions.digitalassistant.model.Diet;
import com.nutritions.digitalassistant.model.Planning;
import com.nutritions.digitalassistant.model.Recipe;
import com.nutritions.digitalassistant.repository.DaysRepository;
import com.nutritions.digitalassistant.repository.DietRepository;
import com.nutritions.digitalassistant.repository.MealsRepository;
import com.nutritions.digitalassistant.repository.PlanningRepository;
import com.nutritions.digitalassistant.repository.RecipeRepository;

@Service
public class PlanningService {

	@Autowired
	private PlanningRepository planningRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private MealsRepository mealsRepository;
	
	@Autowired
	private DaysRepository dayRepository;
	
	@Autowired
	private DietRepository dietRepository;
	
	public void removeRecipe(Integer idDay, Integer idDiet, Integer idMeal, Integer idRecipe) {	
		Planning planning = this.planningRepository.getPlanning(idDay, idDiet, idMeal);
		List<Recipe> recipes =	planning.getRecipesPlanning();
		for(int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getId().equals(idRecipe)) {	
				recipes.remove(i);	
			}	
		}
		this.planningRepository.save(planning);
	}

	public Planning saveRecipeInPlanning(Integer idDay, Integer idDiet, Integer idMeal, Integer idRecipe) {
		Planning planning = this.planningRepository.getPlanning(idDay, idDiet, idMeal);
		if(planning == null) {
			planning = new Planning();
			planning.setMeal(mealsRepository.findById(idMeal).get());
			planning.setDay(dayRepository.findById(idDay).get());
			planning.setDiet(dietRepository.findById(idDiet).get());
			planning.setRecipesPlanning(new ArrayList());			
		}
		Recipe recipe = this.recipeRepository.findById(idRecipe).get();
		List<Recipe> recipes =	planning.getRecipesPlanning();
		recipes.add(recipe);
		return planningRepository.save(planning);
	}

	public Page<Recipe> getAllRecipes(SearchDto searchDto) {
		Sort sortingCriteria = Sort.by("name").ascending();
		List<ConditionDto> conditions = searchDto.getConditions();
		String recipeName = null;
		for (int i = 0; i < conditions.size(); i++) {
			recipeName = conditions.get(0).getCriteria();
		}
		Pageable pageableConfig = PageRequest.of(searchDto.getPageNumber(), searchDto.getPageSize(), sortingCriteria);
		return recipeRepository.findAllByNameContaining(pageableConfig, recipeName);
	}
}

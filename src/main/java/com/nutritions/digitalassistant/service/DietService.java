package com.nutritions.digitalassistant.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.nutritions.digitalassistant.dto.ConditionDto;
import com.nutritions.digitalassistant.dto.DayAndMealsDto;
import com.nutritions.digitalassistant.dto.MealsAndRecipesDto;
import com.nutritions.digitalassistant.dto.MedicalDataDto;
import com.nutritions.digitalassistant.dto.OrderDto;
import com.nutritions.digitalassistant.dto.SearchDto;
import com.nutritions.digitalassistant.model.Day;
import com.nutritions.digitalassistant.model.Diet;
import com.nutritions.digitalassistant.model.Meal;
import com.nutritions.digitalassistant.model.Planning;
import com.nutritions.digitalassistant.model.Recipe;
import com.nutritions.digitalassistant.model.User;
import com.nutritions.digitalassistant.repository.DaysRepository;
import com.nutritions.digitalassistant.repository.DietRepository;
import com.nutritions.digitalassistant.repository.MealsRepository;
import com.nutritions.digitalassistant.repository.UserRepository;

@Service
public class DietService {

	@Autowired
	private DietRepository dietRepository;

	@Autowired
	private MedicalDataService medicalDataService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DaysRepository daysRepository;
	
	@Autowired
	private MealsRepository mealsRepository;

	public Diet saveDiet(MedicalDataDto medicalDataDto) {
		Diet diet = new Diet();
		User user = this.userRepository.findByid(medicalDataDto.getIdUser()).get();
		diet.setUser(user);
		LocalDateTime fechaActual = LocalDateTime.now();
		diet.setDate(fechaActual);
		diet.setType(medicalDataDto.getTypeDiet());
		medicalDataService.parseMedicalData(medicalDataDto);
		return dietRepository.save(diet);
	}

	public List<DayAndMealsDto> getDiet(Integer id) {
		Diet diet = this.dietRepository.getDietByUserId(id);
		if(diet != null) return this.transformDietToDaysAndMealsDto(diet);
		else return null;
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	public List<DayAndMealsDto> getDietById(Integer id) {
		Diet diet = this.dietRepository.getDietById(id);
		List<DayAndMealsDto> daysAndMeals = new ArrayList();
		daysAndMeals = this.transformDietToDaysAndMealsDto(diet);
		List<Day> days = this.daysRepository.findAll();
		for (int i = 0; i < days.size(); i++) {
			Day day = days.get(i);
			DayAndMealsDto dto = null;
			for (int j = 0; j < daysAndMeals.size(); j++) {
				if (day.getId().equals(daysAndMeals.get(j).getOrder())) {
					dto = daysAndMeals.get(j);
				}
			}
			if (dto == null) {
				dto = new DayAndMealsDto();
				dto.setDay(day.getName());
				dto.setOrder(day.getId());
				dto.setMeals(new ArrayList());
				daysAndMeals.add(dto);
			}
			
			this.checkMealsInDay(dto);
		}
		return daysAndMeals;
	}
	
	private DayAndMealsDto checkMealsInDay(DayAndMealsDto dto){		
		List<Meal> meals = this.mealsRepository.findAll();
		for(int i = 0; i < meals.size(); i++) {
			Meal meal = meals.get(i);
			MealsAndRecipesDto dtoMeals = null;
			for(int j = 0; j < dto.getMeals().size(); j++) {
				if(meal.getId().equals(dto.getMeals().get(j).getOrder())){
					dtoMeals = dto.getMeals().get(j);
				}
			}if(dtoMeals == null){
				dtoMeals = new MealsAndRecipesDto();
				dtoMeals.setMeal(meal.getName());
				dtoMeals.setOrder(meal.getId());
				dtoMeals.setRecipes(new ArrayList());
				dto.getMeals().add(dtoMeals);
			}			
		}
		return dto;		
	}

	public List<DayAndMealsDto> transformDietToDaysAndMealsDto(Diet diet) {
		List<DayAndMealsDto> daysAndMeals = new ArrayList();
		HashMap<Integer, List<Planning>> mapByDay = this.getDaysOfPlanning(diet.getPlanning());
		for (Map.Entry<Integer, List<Planning>> entry : mapByDay.entrySet()) {
			DayAndMealsDto dayAndMealDto = new DayAndMealsDto();
			Integer keyPlanning = entry.getKey();
			List<Planning> planningsInDay = entry.getValue();
			Day day = planningsInDay.get(0).getDay();
			dayAndMealDto.setDay(day.getName());
			dayAndMealDto.setOrder(day.getId());
			dayAndMealDto.setMeals(new ArrayList());
			daysAndMeals.add(dayAndMealDto);
			HashMap<String, List<Planning>> mapMealsInDay = this.getMealsOfDays(planningsInDay);
			for (Map.Entry<String, List<Planning>> entrys : mapMealsInDay.entrySet()) {
				List<Planning> mealsAndRecipe = entrys.getValue();
				Meal meal = mealsAndRecipe.get(0).getMeal();
				MealsAndRecipesDto mealsAndRecipeDto = new MealsAndRecipesDto();
				mealsAndRecipeDto.setMeal(meal.getName());
				List<Recipe> recipes = mealsAndRecipe.get(0).getRecipesPlanning();
				mealsAndRecipeDto.setRecipes(recipes);
				mealsAndRecipeDto.setOrder(meal.getId());
				dayAndMealDto.getMeals().add(mealsAndRecipeDto);
			}
		}
		daysAndMeals.sort(Comparator.comparing(DayAndMealsDto::getOrder));
		return daysAndMeals;
	}
	

	private HashMap<Integer, List<Planning>> getDaysOfPlanning(List<Planning> plannings) {
		HashMap<Integer, List<Planning>> planningByDays = new HashMap<>();
		for (int i = 0; i < plannings.size(); i++) {
			Integer day = plannings.get(i).getDay().getId();
			List<Planning> planningListInDay = planningByDays.get(day);
			if (planningListInDay == null) {
				List<Planning> daysArray = new ArrayList<Planning>();
				planningListInDay = daysArray;
				planningByDays.put(day, daysArray);
			}
			
			planningListInDay.add(plannings.get(i));
		}
		return planningByDays;
	}

	public HashMap<String, List<Planning>> getMealsOfDays(List<Planning> plannings) {
		HashMap<String, List<Planning>> planningByMeals = new HashMap<>();
		for (int i = 0; i < plannings.size(); i++) {
			String meals = plannings.get(i).getMeal().getName();
			List<Planning> newPlanningMeals = planningByMeals.get(meals);
			if (newPlanningMeals == null) {
				List<Planning> mealsArray = new ArrayList<Planning>();
				newPlanningMeals = mealsArray;
				planningByMeals.put(meals, mealsArray);
			}
			newPlanningMeals.add(plannings.get(i));
		}
		return planningByMeals;
	}

	public Page<Diet> getAllDiets(SearchDto searchDto) {
		Sort sortingCriteria = null;
		List<OrderDto> listSorts = searchDto.getSort();
		List<ConditionDto> listConditions = searchDto.getConditions();
		String userName = "";
		ArrayList<Integer> listType = new ArrayList<Integer>();
		listType.add(1);
		listType.add(2);
		listType.add(3);
		for (int i = 0; i < listSorts.size(); i++) {
			if (sortingCriteria == null) {
				sortingCriteria = Sort.by(listSorts.get(i).getField());
			} else {
				sortingCriteria = sortingCriteria.and(Sort.by(listSorts.get(i).getField()));
			}

			if (listSorts.get(i).getDirection().equals("ascending")) {
				sortingCriteria = sortingCriteria.ascending();
			} else {
				sortingCriteria = sortingCriteria.descending();
			}
		}
		for (int i = 0; i < listConditions.size(); i++) {
			if (listConditions.get(i).getField().equals("name")) {
				userName = listConditions.get(i).getCriteria();
			} else if (listConditions.get(i).getField().equals("type")) {
				listType = new ArrayList<Integer>();
				listType.add(Integer.parseInt(listConditions.get(i).getCriteria()));
			}
		}
		Pageable sortedByUserName = PageRequest.of(searchDto.getPageNumber(), searchDto.getPageSize(), sortingCriteria);
		return dietRepository.findAllByUser_NameContainingAndTypeIn(sortedByUserName, userName, listType);
	}

	public void deleteDietById(Integer id) {
		dietRepository.deleteById(id);
	}
}

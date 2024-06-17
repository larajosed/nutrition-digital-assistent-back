package com.nutritions.digitalassistant.dto;

import java.io.Serializable;
import java.util.List;


public class DayAndMealsDto implements Serializable {
	private Integer order;
 
	private String day;
	
	private List<MealsAndRecipesDto> meals;
	


	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<MealsAndRecipesDto> getMeals() {
		return meals;
	}

	public void setMeals(List<MealsAndRecipesDto> meals) {
		this.meals = meals;
	}
	
	
	
}

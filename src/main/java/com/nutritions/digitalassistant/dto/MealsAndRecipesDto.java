package com.nutritions.digitalassistant.dto;

import java.io.Serializable;
import java.util.List;


import com.nutritions.digitalassistant.model.Recipe;

public class MealsAndRecipesDto implements Serializable {
	
	private int order;

	private String meal;
	
	private List<Recipe> recipes;
	

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}

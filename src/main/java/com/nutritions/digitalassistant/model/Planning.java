package com.nutritions.digitalassistant.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Planning")
public class Planning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@ManyToOne()
	@JoinColumn(name = "id_day")
	private Day day;
	
	@ManyToOne()
	@JoinColumn(name = "id_meal")
	private Meal meal;

	@ManyToOne
	@JoinColumn(name = "id_diet")
	private Diet diet;
	
	@ManyToMany
	@JoinTable(
			name = "planning_recipe",
			joinColumns = @JoinColumn(name = "id_planning"),
			inverseJoinColumns = @JoinColumn (name = "id_recipe"))
	private List<Recipe> recipesPlanning;
	

	public List<Recipe> getRecipesPlanning() {
		return recipesPlanning;
	}

	public void setRecipesPlanning(List<Recipe> recipesPlanning) {
		this.recipesPlanning = recipesPlanning;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	@JsonIgnore
	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}
	
}

package com.nutritions.digitalassistant.dto;

import java.io.Serializable;

public class MedicalDataDTO implements Serializable {
	
	private Integer id;	
	
	private Integer idUser;
	
	
	private String weight;
	
	
	private String height;
	
	
	private String currentMedical;
	
	
	private String medicalInformation;
	
	private String familyBackground;
	
	private String allergies;
	
	private Integer activityLevel;
	
	
	private Integer typeDiet;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getCurrentMedical() {
		return currentMedical;
	}


	public void setCurrentMedical(String currentMedical) {
		this.currentMedical = currentMedical;
	}


	public String getMedicalInformation() {
		return medicalInformation;
	}


	public void setMedicalInformation(String medicalInformation) {
		this.medicalInformation = medicalInformation;
	}


	public String getFamilyBackground() {
		return familyBackground;
	}


	public void setFamilyBackground(String familyBackground) {
		this.familyBackground = familyBackground;
	}


	public String getAllergies() {
		return allergies;
	}


	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}


	public Integer getActivityLevel() {
		return activityLevel;
	}


	public void setActivityLevel(Integer activityLevel) {
		this.activityLevel = activityLevel;
	}


	public Integer getTypeDiet() {
		return typeDiet;
	}


	public void setTypeDiet(Integer typeDiet) {
		this.typeDiet = typeDiet;
	}
	
	
	
}

package com.nutritions.digitalassistant.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicals_data")
public class MedicalData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer idUser;
	
	@Column 
	private Float weight;
	
	@Column
	private Float height;
	
	@Column
	private String currentMedical;
	
	@Column
	private String medicalInformation;
	
	@Column
	private String familyBackground;
	
	@Column
	private String allergies;
	
	@Column
	private Integer activityLevel;


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

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
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


	
	
	
	
}

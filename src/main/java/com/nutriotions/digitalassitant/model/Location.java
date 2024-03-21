package com.nutriotions.digitalassitant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer idLocation;
	
	@Column
	private Integer idProvince;
	
	@Column
	private Integer controlDigit;
	
	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}

	public Integer getIdProvince() {
		return idProvince;
	}

	public void setIdProvince(Integer idProvince) {
		this.idProvince = idProvince;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getControlDigit() {
		return controlDigit;
	}

	public void setControlDigit(Integer controlDigit) {
		this.controlDigit = controlDigit;
	}
	
	
}

package com.nutriotions.digitalassitant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "roles")
public class Roles {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;

	public Integer getRoleId() {
		return id;
	}

	public void setRoleId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return name;
	}

	public void setRoleName(String nombre) {
		this.name = nombre;
	}
	
	
}

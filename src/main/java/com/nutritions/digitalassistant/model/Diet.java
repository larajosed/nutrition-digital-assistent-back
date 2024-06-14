package com.nutritions.digitalassistant.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "diets")
public class Diet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer type;
	
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private User user;

	@Column
	private LocalDateTime date;
	
	@OneToMany(mappedBy = "diet")
	private List<Planning> planning;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime fechaActual) {
		this.date =  fechaActual;
	}

	public List<Planning> getPlanning() {
		return planning;
	}

	public void setPlanning(List<Planning> planning) {
		this.planning = planning;
	}	
}

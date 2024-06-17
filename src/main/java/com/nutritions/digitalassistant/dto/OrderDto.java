package com.nutritions.digitalassistant.dto;


public class OrderDto {
	private String field;
	private String direction;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String sorting) {
		this.direction = sorting;
	}
	
}

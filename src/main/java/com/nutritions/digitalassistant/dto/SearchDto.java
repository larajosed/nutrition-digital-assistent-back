 /**
 * 
 */
package com.nutritions.digitalassistant.dto;

import java.io.Serializable;
import java.util.List;

public class SearchDto implements Serializable {
	
	private Integer pageNumber;
	private Integer pageSize;
	private List<ConditionDto> conditions;
	private List<OrderDto> sort;	
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<ConditionDto> getConditions() {
		return conditions;
	}
	public void setConditions(List<ConditionDto> conditions) {
		this.conditions = conditions;
	}
	public List<OrderDto> getSort() {
		return sort;
	}
	public void setSort(List<OrderDto> sort) {
		this.sort = sort;
	}
}

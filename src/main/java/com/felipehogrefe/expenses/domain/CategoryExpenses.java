package com.felipehogrefe.expenses.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryExpenses implements Serializable, Comparable<CategoryExpenses>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int category_code;
	private String category_name;
	private double total;
	
	

	
	public CategoryExpenses(Integer id, int category_code, String category_name, double total) {
		super();
		this.id = id;
		this.category_code = category_code;
		this.category_name = category_name;
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryExpenses other = (CategoryExpenses) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(CategoryExpenses arg0) {
		if(total>arg0.total) return 1;
		else if(total<arg0.total) return -1;
		return 0;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getCategory_code() {
		return category_code;
	}


	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	

}

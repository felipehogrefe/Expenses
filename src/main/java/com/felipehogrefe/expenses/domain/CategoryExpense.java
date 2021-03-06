package com.felipehogrefe.expenses.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryExpense implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private int category_code;
	private String category_name;
	private BigDecimal total;
	
	
	public CategoryExpense() {}
	
	public CategoryExpense(Integer id, int category_code, String category_name, BigDecimal total) {
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
		CategoryExpense other = (CategoryExpense) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}

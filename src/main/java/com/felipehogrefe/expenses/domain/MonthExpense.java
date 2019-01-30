package com.felipehogrefe.expenses.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MonthExpense implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private String movimentation_month;
	private BigDecimal total;
	
	public MonthExpense() {}

	public MonthExpense(Integer id, String movimentation_month, BigDecimal total) {
		super();
		this.id = id;
		this.movimentation_month = movimentation_month;
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
		MonthExpense other = (MonthExpense) obj;
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

	public String getMovimentation_month() {
		return movimentation_month;
	}

	public void setMovimentation_month(String movimentation_month) {
		this.movimentation_month = movimentation_month;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}

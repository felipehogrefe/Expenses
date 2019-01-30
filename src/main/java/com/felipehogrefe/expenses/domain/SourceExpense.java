package com.felipehogrefe.expenses.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SourceExpense implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private int source_code;
	private String source_name;
	private BigDecimal total;
	
	public SourceExpense() {}
	
	public SourceExpense(Integer id, int source_code, String source_name, BigDecimal total) {
		super();
		this.id = id;
		this.source_code = source_code;
		this.source_name = source_name;
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
		SourceExpense other = (SourceExpense) obj;
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

	public int getSource_code() {
		return source_code;
	}

	public void setSource_code(int source_code) {
		this.source_code = source_code;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}

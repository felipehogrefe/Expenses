package com.felipehogrefe.expenses.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SourceExpenses implements Serializable, Comparable<SourceExpenses>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int source_code;
	private String source_name;
	private double total;
	
	public SourceExpenses(Integer id, int source_code, String source_name, double total) {
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
		SourceExpenses other = (SourceExpenses) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(SourceExpenses arg0) {
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}

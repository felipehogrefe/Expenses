package com.felipehogrefe.expenses.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MonthExpense implements Serializable, Comparable<MonthExpense>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String mes_movimentacao;
	private double total;
	

	public MonthExpense(Integer id, String mes_movimentacao, double total) {
		super();
		this.id = id;
		this.mes_movimentacao = mes_movimentacao;
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

	@Override
	public int compareTo(MonthExpense arg0) {
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

	public String getMes_movimentacao() {
		return mes_movimentacao;
	}

	public void setMes_movimentacao(String mes_movimentacao) {
		this.mes_movimentacao = mes_movimentacao;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

}

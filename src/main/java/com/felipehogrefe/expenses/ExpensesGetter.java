package com.felipehogrefe.expenses;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import com.felipehogrefe.expenses.repositories.ExpenseRepository;

public class ExpensesGetter {
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public ExpensesGetter() {
		
	}
	
	public void getExpenses(String url, boolean limit, int limitTotal) throws JSONException, IOException {
		UrlToExpensesParser utep = new UrlToExpensesParser(url+(limit?("&limit="+limitTotal):""));
		expenseRepository.saveAll(utep.getExpenses());
	}
}

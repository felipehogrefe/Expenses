package com.felipehogrefe.expenses;

import java.io.IOException;
import org.json.JSONException;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.felipehogrefe.expenses.services.ExpenseService;

public class ExpensesGetter {

	private ExpenseRepository expenseRepository;
	private ExpenseService expenseService;
	private int limit;

	public ExpensesGetter(ExpenseRepository _expenseRepository) {
		expenseRepository = _expenseRepository;
	}
	
	public ExpensesGetter(int _limit) {
		limit = _limit;
	}

	public ExpensesGetter(int _limit, ExpenseRepository _expenseRepository, ExpenseService _expenseService) {
		limit = _limit;
		expenseService = _expenseService;
		expenseRepository = _expenseRepository;
	}

	public void getExpenses(int querySize) {
		try {
			for (int i = 0; i < limit; i += querySize) {

				UrlToExpensesParser utep = new UrlToExpensesParser(
						"http://dados.recife.pe.gov.br/api/action/datastore_search?"
								+ "resource_id=d4d8a7f0-d4be-4397-b950-f0c991438111&limit=" + querySize + "&offset="
								+ i);

				expenseRepository.saveAll(utep.getExpenses());

				expenseService.defineTotals(utep.getExpenses());
			}

		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

	}

	
}

package com.felipehogrefe.expenses;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONException;

import com.felipehogrefe.expenses.domain.CategoryExpense;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.domain.MonthExpense;
import com.felipehogrefe.expenses.domain.SourceExpense;
import com.felipehogrefe.expenses.repositories.CategoryExpenseRepository;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.felipehogrefe.expenses.repositories.MonthExpenseRepository;
import com.felipehogrefe.expenses.repositories.SourceExpenseRepository;

public class ExpensesGetter {

	public static final String[] monthsNames = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
			"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

	private ExpenseRepository expenseRepository;
	private CategoryExpenseRepository categoryExpenseRepository;
	private SourceExpenseRepository sourceExpenseRepository;
	private MonthExpenseRepository monthExpenseRepository;
	private int limit;

	public ExpensesGetter(ExpenseRepository _expenseRepository) {
		expenseRepository = _expenseRepository;
	}

	public ExpensesGetter(int _limit, ExpenseRepository _expenseRepository,
			CategoryExpenseRepository _categoryExpenseRepository, SourceExpenseRepository _sourceExpenseRepository,
			MonthExpenseRepository _monthExpenseRepository) {
		limit = _limit;
		expenseRepository = _expenseRepository;
		categoryExpenseRepository = _categoryExpenseRepository;
		sourceExpenseRepository = _sourceExpenseRepository;
		monthExpenseRepository = _monthExpenseRepository;
	}

	public void getExpenses(int querySize) {
		try {
			for (int i = 0; i < limit; i += querySize) {

				UrlToExpensesParser utep = new UrlToExpensesParser(
						"http://dados.recife.pe.gov.br/api/action/datastore_search?"
								+ "resource_id=d4d8a7f0-d4be-4397-b950-f0c991438111&limit=" + querySize + "&offset="
								+ i);

				expenseRepository.saveAll(utep.getExpenses());

				for (Expense e : utep.getExpenses()) {

					double expenseValue = Double.parseDouble(e.getValor_liquidado().replace(",", "."));

					editCategory(e, expenseValue);
					editMonth(e, expenseValue);
					editSource(e, expenseValue);
				}
			}

		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void editCategory(Expense e, double expenseValue) {
		Optional<CategoryExpense> oce = categoryExpenseRepository.findById(e.getCategoria_economica_codigo());
		CategoryExpense ce;
		if (oce.isPresent()) {
			ce = oce.get();
			ce.setTotal(expenseValue + ce.getTotal());
		} else {
			ce = new CategoryExpense(e.getCategoria_economica_codigo(), e.getCategoria_economica_codigo(),
					e.getCategoria_economica_nome(), expenseValue);
		}
		categoryExpenseRepository.save(ce);
	}

	private void editMonth(Expense e, double expenseValue) {
		Optional<MonthExpense> ome = monthExpenseRepository.findById(e.getMes_movimentacao());
		MonthExpense me;
		if (ome.isPresent()) {
			me = ome.get();
			me.setTotal(expenseValue + me.getTotal());
		} else {
			me = new MonthExpense(e.getMes_movimentacao(), monthsNames[e.getMes_movimentacao() - 1], expenseValue);
		}
		monthExpenseRepository.save(me);
	}

	private void editSource(Expense e, double expenseValue) {
		Optional<SourceExpense> ose = sourceExpenseRepository.findById(e.getFonte_recurso_codigo());
		SourceExpense se;
		if (ose.isPresent()) {
			se = ose.get();
			se.setTotal(expenseValue + se.getTotal());
		} else {
			se = new SourceExpense(e.getFonte_recurso_codigo(), e.getFonte_recurso_codigo(), e.getFonte_recurso_nome(),
					expenseValue);
		}
		sourceExpenseRepository.save(se);
	}
}

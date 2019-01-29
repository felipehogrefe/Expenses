package com.felipehogrefe.expenses.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.google.gson.Gson;

@Service
public class ExpenseService {
	private static final int chunkSize = 10;
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private MonthExpenseService monthExpenseService;
	@Autowired
	private CategoryExpenseService categoryExpenseService;
	@Autowired
	private SourceExpenseService sourceExpenseService;

	public Optional<Expense> find(Integer id) {
		Optional<Expense> obj = expenseRepository.findById(id);
		return obj;
	}

	public List<Expense> getExpenseList() {
		return expenseRepository.findAll();
	}

	public boolean editExpense(Expense e) {
		Optional<Expense> oldExpense = find(e.getId());
		if (oldExpense.isPresent()) {
			if (expenseRepository.save(e) != null) {
				double newValue = Double.parseDouble(e.getValor_liquidado().replace(",", "."))
						- Double.parseDouble(oldExpense.get().getValor_liquidado().replace(",", "."));
				editTotals(newValue, e);
				return true;
			}

		}
		return false;
	}

	public boolean addExpense(Expense e) {
		if (expenseRepository.save(e) != null) {
			{				
				addTotals(e);
				return true;
			}
		}
		return false;
	}

	public List<Expense> getExpenseListChunk(int chunk) {
		List<Expense> list = new ArrayList<Expense>();
		List<Expense> expenseList = expenseRepository.findAll();
		int index = chunk * chunkSize;
		while (list.size() < chunkSize && list.size() < (expenseList.size())) {
			Expense e = expenseList.get(index++);
			list.add(e);
		}
		return list;
	}

	public void removeExpense(Expense e) {
		removeFromDB(e);
		expenseRepository.delete(e);

	}

	public List<Expense> getExpenseListByCode(String fieldName, Integer code) {
		List<Expense> list = new ArrayList<Expense>();
		try {
			if (fieldName.equals("fonte_recurso_codigo")) {
				list = expenseRepository.findBySourceCode(code);
			} 
			
			else {
				List<Expense> completeList = expenseRepository.findAll();
				for (Expense e : completeList) {
					if ((int) Expense.class.getField(fieldName).get(e) == code)
						list.add(e);
				}
			}
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String getAtributesNames() {
		String json = new Gson().toJson(getAtributesNamesList());
		return json;
	}

	public List<String> getAtributesNamesList() {
		Field[] fields = Expense.class.getFields();
		List<String> list = new ArrayList<>();
		for (Field f : fields) {
			if (f.getName().contains("codigo")) {
				list.add(f.getName());
			}
		}

		return list;
	}

	private void removeFromDB(Expense e) {
		monthExpenseService.remove(e);
		categoryExpenseService.remove(e);
		sourceExpenseService.remove(e);
	}

	public void defineTotals(List<Expense> list) {
		for (Expense e : list) {
			double expenseValue = Double.parseDouble(e.getValor_liquidado().replace(",", "."));

			categoryExpenseService.editCategory(e, expenseValue);
			monthExpenseService.editMonth(e, expenseValue);
			sourceExpenseService.editSource(e, expenseValue);
		}
	}

	public void addTotals(Expense expense) {
		editTotals(Double.parseDouble(expense.getValor_liquidado().replace(",", ".")), expense);
	}

	public void editTotals(Double expenseValue, Expense expense) {
		categoryExpenseService.editCategory(expense, expenseValue);
		monthExpenseService.editMonth(expense, expenseValue);
		sourceExpenseService.editSource(expense, expenseValue);
	}

	public List<Integer> getSourcesAvailableCodes() {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> hash = new HashSet<Integer>();

		List<Expense> completeList = expenseRepository.findAll();
		for (Expense e : completeList) {
			hash.add(e.getFonte_recurso_codigo());
		}
		list.addAll(hash);
		return list;
	}
}

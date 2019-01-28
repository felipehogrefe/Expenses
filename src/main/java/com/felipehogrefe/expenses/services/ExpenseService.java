package com.felipehogrefe.expenses.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
		if (expenseRepository.save(e) != null) {
			defineTotals(Arrays.asList(e));
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param chunk
	 * @return a list of expenses, from the (chunk*chunkSize)th expense to the (chunk*chunkSize + chunkSize)th expense, ordered by id
	 */
	public List<Expense> getExpenseListChunk(int chunk) {
		List<Expense> list = new ArrayList<Expense>();
		List<Expense> expenseList = expenseRepository.findAll();
		int index = chunk * chunkSize;
		while (list.size() < chunkSize && list.size()<(expenseList.size())) {
			Expense e = expenseList.get(index++);
			list.add(e);
		}
		return list;
	}

	public void removeExpense(Expense e) {
		removeFromDB(e);
		expenseRepository.delete(e);

	}

	public List<Expense> getExpenseListByCode(String string, Integer code) {
		List<Expense> list = new ArrayList<Expense>();
		try {
			List<Expense> completeList = getExpenseList();
			for (Expense e : completeList) {
				if ((int) Expense.class.getField(string).get(e) == code)
					list.add(e);
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
		for(Field f : fields) {
			if(f.getName().contains("codigo")) {
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
	
	public void defineTotals(List<Expense> list){
		for (Expense e : list) {

			double expenseValue = Double.parseDouble(e.getValor_liquidado().replace(",", "."));

			categoryExpenseService.editCategory(e, expenseValue);
			monthExpenseService.editMonth(e, expenseValue);
			sourceExpenseService.editSource(e, expenseValue);
		}
	}	
}

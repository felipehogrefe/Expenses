package com.felipehogrefe.expenses.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.google.gson.Gson;

@Service
public class ExpenseService {
	private static final int listSize = 10;
	@Autowired
	private ExpenseRepository expenseRepository;

	public Optional<Expense> find(Integer id) {
		Optional<Expense> obj = expenseRepository.findById(id);
		return obj;
	}

	public List<Expense> getExpenseList() {
		return expenseRepository.findAll();
	}

	public boolean editExpense(Expense e) {
		if (expenseRepository.save(e) != null)
			return true;
		return false;
	}

	public List<Expense> getExpenseList(int chunk) {
		List<Expense> list = new ArrayList<Expense>();
		List<Expense> expenseList = expenseRepository.findAll();
		int index = chunk * listSize;
		while (list.size() < listSize) {
			Expense e = expenseList.get(index++);
			list.add(e);
		}
		return list;
	}

	public void removeExpense(Integer id) {
		expenseRepository.deleteById(id);

	}

	public List<Expense> getExpenseListByCode(Integer code, String string) {
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
		Field[] fields = Expense.class.getFields();
		List<String> list = new ArrayList<>();
		for(Field f : fields) {
			if(f.getName().contains("codigo")) {
				list.add(f.getName());
			}
		}
		String json = new Gson().toJson(list);

		return json;
	}

}

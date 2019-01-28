package com.felipehogrefe.expenses.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.CategoryExpense;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.repositories.CategoryExpenseRepository;


@Service
public class CategoryExpenseService {
	@Autowired
	private CategoryExpenseRepository categoryExpenseRepository;
	
	public Optional<CategoryExpense> find(Integer id) {
		Optional<CategoryExpense> obj = categoryExpenseRepository.findById(id);
		return obj;
	}
	
	public List<CategoryExpense> getCompleteList(){		
		return categoryExpenseRepository.findAll(); 		
	}

	public void remove(Expense e) {
		List<CategoryExpense> list = getCompleteList();
		for(CategoryExpense ce : list) {
			if(e.getCategoriaEconomicaCodigo()==ce.getCategory_code()) {
				ce.setTotal(ce.getTotal()-Double.parseDouble(e.getValorPago().replace(",", ".")));
				categoryExpenseRepository.save(ce);
				return;
			}
		}
	}
	
	public void editCategory(Expense e, double expenseValue) {
		Optional<CategoryExpense> oce = categoryExpenseRepository.findById(e.getCategoriaEconomicaCodigo());
		CategoryExpense ce;
		if (oce.isPresent()) {
			ce = oce.get();
			ce.setTotal(expenseValue + ce.getTotal());
		} else {
			ce = new CategoryExpense(e.getCategoriaEconomicaCodigo(), e.getCategoriaEconomicaCodigo(),
					e.getCategoriaEconomicaNome(), expenseValue);
		}
		categoryExpenseRepository.save(ce);
	}
}

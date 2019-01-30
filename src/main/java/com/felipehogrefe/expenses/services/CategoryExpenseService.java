package com.felipehogrefe.expenses.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

	/** Given an expense and updates CategoryExpense by updating the total of the category, notice that even if the total value becomes 0 its not removed.
	 * @param The removed expense 
	 */
	public void remove(Expense e) {
		List<CategoryExpense> list = getCompleteList();
		for(CategoryExpense ce : list) {
			if(e.getCategoria_economica_codigo()==ce.getCategory_code()) {
				ce.setTotal(ce.getTotal().subtract(BigDecimal.valueOf(Double.parseDouble(e.getValor_pago().replace(",", "."))).setScale(2,RoundingMode.HALF_UP)));
				categoryExpenseRepository.save(ce);
				return;
			}
		}
	}
	
	/**
	 * Given an expense and a new total value edits the corresponding CategoryExpense by setting the new total, if it is present, or creates a new one.
	 * @param e The expense that has been edited, its used to find the corresponding category. 
	 * @param expenseValue A value to update the category total.
	 */
	public void editCategory(Expense e, double expenseValue) {
		Optional<CategoryExpense> oce = categoryExpenseRepository.findById(e.getCategoria_economica_codigo());
		CategoryExpense ce;
		BigDecimal newValue = BigDecimal.valueOf(expenseValue);
		if (oce.isPresent()) {
			ce = oce.get();
			ce.setTotal(newValue.add(ce.getTotal()));
		} else {
			ce = new CategoryExpense(e.getCategoria_economica_codigo(), e.getCategoria_economica_codigo(),
					e.getCategoria_economica_nome(), newValue);
		}
		categoryExpenseRepository.save(ce);
	}
}

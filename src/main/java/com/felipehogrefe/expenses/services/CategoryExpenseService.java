package com.felipehogrefe.expenses.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.CategoryExpense;
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
	
	
}

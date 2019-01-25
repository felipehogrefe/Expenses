package com.felipehogrefe.gamesranking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.gamesranking.domain.Expense;
import com.felipehogrefe.gamesranking.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Optional<Expense> find(Integer id) {
		Optional<Expense> obj = expenseRepository.findById(id);
		return obj;
	}
	
	public List<Expense> getExpenseList(){		
		return expenseRepository.findAll(); 		
	}
	
	public boolean editExpense(Expense e) {
		if(expenseRepository.save(e)!=null) return true;
		return false;
	}
}

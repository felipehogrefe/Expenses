package com.felipehogrefe.expenses.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.MonthExpense;
import com.felipehogrefe.expenses.repositories.MonthExpenseRepository;

@Service
public class MonthExpenseService {
	@Autowired
	private MonthExpenseRepository monthExpenseRepository;
	
	public Optional<MonthExpense> find(Integer id) {
		Optional<MonthExpense> obj = monthExpenseRepository.findById(id);
		return obj;
	}
	
	public List<MonthExpense> getCompleteList(){		
		return monthExpenseRepository.findAll(); 		
	}
	
}

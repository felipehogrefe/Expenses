package com.felipehogrefe.expenses.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	private static final int listSize = 10;
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

	public List<Expense> getExpenseList(int from) {
		ArrayList<Expense> list = new ArrayList<Expense>();
		for(int i = from;i<from+listSize;i++) {

			Optional<Expense> e = expenseRepository.findById(i);
			if(e.isPresent()) list.add(e.get());
		}
		return list;
	}


}

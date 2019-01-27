package com.felipehogrefe.expenses.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.ExpensesGetter;
import com.felipehogrefe.expenses.domain.Expense;
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

	public void remove(Expense e) {
		List<MonthExpense> list = getCompleteList();
		for(MonthExpense me : list) {
			if(ExpensesGetter.monthsNames[e.getMes_movimentacao()-1].equals(me.getMovimentation_month())) {
				me.setTotal(me.getTotal()-Double.parseDouble(e.getValor_pago().replace(",", ".")));
				monthExpenseRepository.save(me);
				return;
			}
		}
		
	}
	
}

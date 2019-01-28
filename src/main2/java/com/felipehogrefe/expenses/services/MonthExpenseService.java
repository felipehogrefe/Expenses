package com.felipehogrefe.expenses.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.domain.MonthExpense;
import com.felipehogrefe.expenses.repositories.MonthExpenseRepository;

@Service
public class MonthExpenseService {
	@Autowired
	private MonthExpenseRepository monthExpenseRepository;
	
	public static final String[] monthsNames = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
			"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
	
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
			if(monthsNames[e.getMesMovimentacao()-1].equals(me.getMovimentation_month())) {
				me.setTotal(me.getTotal()-Double.parseDouble(e.getValorPago().replace(",", ".")));
				monthExpenseRepository.save(me);
				return;
			}
		}	
	}
	
	void editMonth(Expense e, double expenseValue) {
		Optional<MonthExpense> ome = monthExpenseRepository.findById(e.getMesMovimentacao());
		MonthExpense me;
		if (ome.isPresent()) {
			me = ome.get();
			me.setTotal(expenseValue + me.getTotal());
		} else {
			me = new MonthExpense(e.getMesMovimentacao(), monthsNames[e.getMesMovimentacao() - 1], expenseValue);
		}
		monthExpenseRepository.save(me);
	}
	
}

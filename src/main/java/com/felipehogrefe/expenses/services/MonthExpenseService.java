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

	/** Given an expense and updates MonthExpense by updating the total of the category, notice that even if the total value becomes 0 its not removed.
	 * @param The removed expense.
	 */
	public void remove(Expense e) {
		List<MonthExpense> list = getCompleteList();
		for(MonthExpense me : list) {
			if(monthsNames[e.getMes_movimentacao()-1].equals(me.getMovimentation_month())) {
				me.setTotal(me.getTotal()-Double.parseDouble(e.getValor_pago().replace(",", ".")));
				monthExpenseRepository.save(me);
				return;
			}
		}	
	}
	
	/**
	 * Given an expense and a new total value edits the corresponding MonthExpense by setting the new total, if it is present, or creates a new one.
	 * @param e The expense that has been edited, its used to find the corresponding month. 
	 * @param expenseValue A value to update the month total.
	 */
	void editMonth(Expense e, double expenseValue) {
		Optional<MonthExpense> ome = monthExpenseRepository.findById(e.getMes_movimentacao());
		MonthExpense me;
		if (ome.isPresent()) {
			me = ome.get();
			me.setTotal(expenseValue + me.getTotal());
		} else {
			me = new MonthExpense(e.getMes_movimentacao(), monthsNames[e.getMes_movimentacao() - 1], expenseValue);
		}
		monthExpenseRepository.save(me);
	}
	
}

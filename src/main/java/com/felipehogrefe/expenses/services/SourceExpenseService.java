package com.felipehogrefe.expenses.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.domain.SourceExpense;
import com.felipehogrefe.expenses.repositories.SourceExpenseRepository;

@Service
public class SourceExpenseService {
	@Autowired
	private SourceExpenseRepository sourceExpenseRepository;
	
	public Optional<SourceExpense> find(Integer id) {
		Optional<SourceExpense> obj = sourceExpenseRepository.findById(id);
		return obj;
	}
	
	public List<SourceExpense> getCompleteList(){		
		return sourceExpenseRepository.findAll(); 		
	}

	/** Given an expense and updates SourceExpense by updating the total of the category, notice that even if the total value becomes 0 its not removed.
	 * @param The removed expense. 
	 */
	public void remove(Expense e) {
		List<SourceExpense> list = getCompleteList();
		for(SourceExpense se : list) {
			if(e.getFonte_recurso_codigo()==se.getSource_code()) {
				se.setTotal(se.getTotal()-Double.parseDouble(e.getValor_pago().replace(",", ".")));
				sourceExpenseRepository.save(se);
				return;
			}
		}
	}

	/**
	 * Given an expense and a new total value edits the corresponding SourceExpense by setting the new total, if it is present, or creates a new one.
	 * @param e The expense that has been edited, its used to find the corresponding source. 
	 * @param expenseValue A value to update the source total.
	 */
	public void editSource(Expense e, double expenseValue) {
		Optional<SourceExpense> ose = sourceExpenseRepository.findById(e.getFonte_recurso_codigo());
		SourceExpense se;
		if (ose.isPresent()) {
			se = ose.get();
			se.setTotal(expenseValue + se.getTotal());
		} else {
			se = new SourceExpense(e.getFonte_recurso_codigo(), e.getFonte_recurso_codigo(), e.getFonte_recurso_nome(),
					expenseValue);
		}
		sourceExpenseRepository.save(se);
	}
	
	
}

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

	public void remove(Expense e) {
		List<SourceExpense> list = getCompleteList();
		for(SourceExpense se : list) {
			if(e.getFonteRecursoCodigo()==se.getSource_code()) {
				se.setTotal(se.getTotal()-Double.parseDouble(e.getValorPago().replace(",", ".")));
				sourceExpenseRepository.save(se);
				return;
			}
		}
	}

	public void editSource(Expense e, double expenseValue) {
		Optional<SourceExpense> ose = sourceExpenseRepository.findById(e.getFonteRecursoCodigo());
		SourceExpense se;
		if (ose.isPresent()) {
			se = ose.get();
			se.setTotal(expenseValue + se.getTotal());
		} else {
			se = new SourceExpense(e.getFonteRecursoCodigo(), e.getFonteRecursoCodigo(), e.getFonteRecursoNome(),
					expenseValue);
		}
		sourceExpenseRepository.save(se);
	}
	
	
}

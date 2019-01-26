package com.felipehogrefe.expenses.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	
}

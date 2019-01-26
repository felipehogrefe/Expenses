package com.felipehogrefe.expenses.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.felipehogrefe.expenses.domain.MonthExpense;
import com.felipehogrefe.expenses.services.MonthExpenseService;

@RestController
@RequestMapping(value="/monthexpenses")
public class MonthExpenseResource {
	@Autowired
	private MonthExpenseService monthExpenseService;
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public Optional<MonthExpense> find(@PathVariable Integer id) {	
		return monthExpenseService.find(id);
	}

	@CrossOrigin
	@GetMapping(value="/all")
	public List<MonthExpense> findAll() {	
		return monthExpenseService.getCompleteList();
	}	
	
}

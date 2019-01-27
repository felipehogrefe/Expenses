package com.felipehogrefe.expenses.resources;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipehogrefe.expenses.domain.MonthExpense;
import com.felipehogrefe.expenses.domain.SourceExpense;
import com.felipehogrefe.expenses.services.SourceExpenseService;

@RestController
@RequestMapping(value="/sourceexpenses")
public class SourceExpenseResource {
	@Autowired
	private SourceExpenseService sourceExpenseService;
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<SourceExpense> find(@PathVariable Integer id) {	
		Optional<SourceExpense> expense = sourceExpenseService.find(id);
		if(expense.isPresent()){
			return ResponseEntity.ok(expense.get());	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@CrossOrigin
	@GetMapping(value="/all")
	public ResponseEntity<List<SourceExpense>> findAll() {	
		return ResponseEntity.ok(sourceExpenseService.getCompleteList());
	}
}

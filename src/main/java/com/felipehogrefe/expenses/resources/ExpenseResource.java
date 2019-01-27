package com.felipehogrefe.expenses.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.services.ExpenseService;

@RestController
@RequestMapping(value="/expenses")
public class ExpenseResource {
	@Autowired
	private ExpenseService expenseService;
	
	@CrossOrigin
	@GetMapping(value="/offset/{from}")
	public List<Expense> findAll(@PathVariable int from) {	
		return expenseService.getExpenseList(from);
	}
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public Optional<Expense> find(@PathVariable Integer id) {	
		return expenseService.find(id);
	}

	@CrossOrigin
	@GetMapping(value="/month")
	public List<Expense> getByMonth() {	
		return expenseService.getExpenseList();
	}
	
	@CrossOrigin
	@GetMapping(value="/category")
	public List<Expense> getByCategory() {	
		return expenseService.getExpenseList();		
	}
	
	@CrossOrigin
	@GetMapping(value="/source")
	public List<Expense> getBySource(){
		return expenseService.getExpenseList();
	}
	
	@PostMapping(value="/edit/{id}")
	public ResponseEntity<?> edit(@RequestBody Expense e){
		Optional<Expense> expense = expenseService.find(e.getId());
		if(expense.isPresent()){
			expenseService.editExpense(e);
			return ResponseEntity.ok(HttpStatus.OK);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}

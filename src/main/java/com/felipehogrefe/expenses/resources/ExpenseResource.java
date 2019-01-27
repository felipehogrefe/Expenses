package com.felipehogrefe.expenses.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<List<Expense>> findAll(@PathVariable int from) {	
		return ResponseEntity.ok(expenseService.getExpenseList(from));
	}
	
	@CrossOrigin
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> newPlayer(@RequestBody Integer id){
		expenseService.removeExpense(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<Expense> find(@PathVariable Integer id) {	
		Optional<Expense> expense = expenseService.find(id);
		if(expense.isPresent()){
			return ResponseEntity.ok(expense.get());	
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@GetMapping(value="/month")
	public ResponseEntity<List<Expense>> getByMonth() {	
		return ResponseEntity.ok(expenseService.getExpenseList());
	}
	
	@CrossOrigin
	@GetMapping(value="/category")
	public ResponseEntity<List<Expense>> getByCategory() {	
		return ResponseEntity.ok(expenseService.getExpenseList());		
	}
	
	@CrossOrigin
	@GetMapping(value="/source")
	public ResponseEntity<List<Expense>> getBySource(){
		return ResponseEntity.ok(expenseService.getExpenseList());
	}
	
	@PostMapping(value="/edit")
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

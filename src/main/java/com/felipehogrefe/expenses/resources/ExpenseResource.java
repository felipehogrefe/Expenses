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
import org.springframework.web.bind.annotation.PutMapping;
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
		List<Expense> list = expenseService.getExpenseListChunk(from);
		if(list==null) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(expenseService.getExpenseListChunk(from));
		}
	}
	
	@CrossOrigin
	@GetMapping(value="/sourceavailablecodes")
	public ResponseEntity<List<Integer>> getSourcesAvailableCodes() {	
		return ResponseEntity.ok(expenseService.getSourcesAvailableCodes());
	}
	
	
	@CrossOrigin
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<?> removeExpense(@PathVariable Integer id){
		Optional<Expense> oe = expenseService.find(id);
		if(oe.isPresent()) {
			Expense e = oe.get();
			expenseService.removeExpense(e);		
			return ResponseEntity.ok(HttpStatus.OK);
		}else {
			return ResponseEntity.badRequest().build();			
		}
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
	@GetMapping(value="/{att}/{code}")
	public ResponseEntity<List<Expense>> getByCodigo(@PathVariable String att, @PathVariable Integer code) {
		List<Expense> list = expenseService.getExpenseListByCode(att, code);
		if(list==null) return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(list);		
	}
	
	@CrossOrigin
	@GetMapping(value="/atributes")
	public ResponseEntity<List<String>> getAtributesNames() {	
		return ResponseEntity.ok(expenseService.getCodeAtributesNamesList());		
	}

	
	@CrossOrigin
	@PutMapping(value="/edit")
	public ResponseEntity<?> editExpense(@RequestBody Expense e){
		Optional<Expense> expense = expenseService.find(e.getId());
		if(expense.isPresent()){
			expenseService.editExpense(e);
			return ResponseEntity.ok(HttpStatus.OK);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}

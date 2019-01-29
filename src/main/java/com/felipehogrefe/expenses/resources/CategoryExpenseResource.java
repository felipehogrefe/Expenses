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
import com.felipehogrefe.expenses.domain.CategoryExpense;
import com.felipehogrefe.expenses.services.CategoryExpenseService;

@RestController
@RequestMapping(value="/categoryexpenses")
public class CategoryExpenseResource {
	@Autowired
	private CategoryExpenseService categoryExpenseService;
	
	/**
	 * Given an id queries the database in order to find a corresponding object.
	 * @param id
	 * @return A Http response with the object if there's a match, o a Http notFound otherwise.
	 */
	@CrossOrigin
	@GetMapping(value="/{id}")
	public  ResponseEntity<CategoryExpense> find(@PathVariable Integer id) {	
		Optional<CategoryExpense> expense = categoryExpenseService.find(id);
		if(expense.isPresent()){
			return ResponseEntity.ok(expense.get());	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * Queries the database using the corresponding service in order to find all the objects.
	 * @return A http with the resulting list, if there no data in database the list will be empty
	 */
	@CrossOrigin
	@GetMapping(value="/all")
	public ResponseEntity<List<CategoryExpense>> findAll() {	
		return ResponseEntity.ok(categoryExpenseService.getCompleteList());
	}	
}

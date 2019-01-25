package com.felipehogrefe.gamesranking.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipehogrefe.gamesranking.domain.Expense;
import com.felipehogrefe.gamesranking.services.ExpenseService;

@RestController
@RequestMapping(value="/player")
public class ExpenseResource {
	@Autowired
	private ExpenseService expenseService;
	
	@CrossOrigin
	@PutMapping(value="/increaseMatches/{id}")
	public ResponseEntity<?> increaseMatches(@PathVariable Integer id) {	
		Optional<Expense> player = expenseService.find(id);
		if(player.isPresent()){
			expenseService.addMatchToPlayer(player.get());
			return ResponseEntity.ok(HttpStatus.OK);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PutMapping(value="/increaseVictories/{id}")
	public ResponseEntity<?> increaseVictories(@PathVariable Integer id) {	
		Optional<Expense> player = expenseService.find(id);
		if(player.isPresent()){
			expenseService.addVictoryToPlayer(player.get());
			return ResponseEntity.ok(HttpStatus.OK);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@CrossOrigin
	@GetMapping(value="/orderedList")
	public List<Expense> increaseVictories() {	
		return expenseService.getListOfPlayersOrderedByVictory();		
	}
	
	@CrossOrigin
	@PostMapping(value="/new")
	public ResponseEntity<?> newPlayer(@RequestBody Expense player){
		expenseService.addPlayer(player);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
}

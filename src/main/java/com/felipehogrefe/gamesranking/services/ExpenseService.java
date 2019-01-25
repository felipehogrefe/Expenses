package com.felipehogrefe.gamesranking.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.gamesranking.domain.Expense;
import com.felipehogrefe.gamesranking.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Optional<Expense> find(Integer id) {
		Optional<Expense> obj = expenseRepository.findById(id);
		return obj;
	}
	
	public List<Expense> getPlayersList(){		
		return expenseRepository.findAll(); 		
	}
	
	public List<Expense> getListOfPlayersOrderedByVictory(){		
		List<Expense> list = expenseRepository.findAll();
		Collections.sort(list);
		return list; 		
	}
	
	public boolean addPlayer(Expense p) {
		return changePlayer(p);
	}
	
	public boolean addMatchToPlayer(Expense p) {	
		
		return changePlayer(p);
	}
	public boolean addVictoryToPlayer(Expense p) {	
		
		return changePlayer(p);
	}
	
	private boolean changePlayer(Expense p) {
		if(expenseRepository.save(p)!=null) return true;
		return false;
	}
}

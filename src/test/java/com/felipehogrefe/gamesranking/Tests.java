package com.felipehogrefe.gamesranking;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
	private static boolean setUpIsDone = false;

	@Autowired
	ExpenseRepository playerRepository;
	
	@Autowired
	ExpenseRepository playerService;
	
	@Before
	public void setUp() {
		if(setUpIsDone) {
			return;
		}
		setUpIsDone = true;
	}
	
	
	
	
}

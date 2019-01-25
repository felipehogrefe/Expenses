package com.felipehogrefe.gamesranking;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.felipehogrefe.gamesranking.domain.Expense;
import com.felipehogrefe.gamesranking.repositories.ExpenseRepository;
import com.felipehogrefe.gamesranking.services.ExpenseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamesRankingApplicationTests {
	private static Expense p1, p2, p3, p4;
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

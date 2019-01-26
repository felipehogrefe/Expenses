package com.felipehogrefe.expenses;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.repositories.CategoryExpenseRepository;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.felipehogrefe.expenses.repositories.MonthExpenseRepository;
import com.felipehogrefe.expenses.repositories.SourceExpenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private CategoryExpenseRepository categoryExpenseRepository;
	@Autowired
	private SourceExpenseRepository sourceExpenseRepository;
	@Autowired
	private MonthExpenseRepository monthExpenseRepository;
	
	

	private static final int limitTotal = 500;
	

	@Test
	public void download100Records() {
		ExpensesGetter eg = new ExpensesGetter(100, expenseRepository, categoryExpenseRepository, 
				sourceExpenseRepository, monthExpenseRepository);
		eg.getExpenses(limitTotal);
				
		List<Expense> expenses = expenseRepository.findAll();
		System.out.println(expenses.size());
		
		assertTrue(expenses.size()==limitTotal);
	}
	
	@Test
	public void checkCategoryTotalValue() {
		
	}	
	@Test
	public void checkMonthTotalValue() {
		
	}	
	@Test
	public void checkSourceTotalValue() {
		
	}	
}

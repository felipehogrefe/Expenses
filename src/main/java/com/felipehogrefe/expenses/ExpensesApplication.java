package com.felipehogrefe.expenses;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipehogrefe.expenses.repositories.CategoryExpenseRepository;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.felipehogrefe.expenses.repositories.MonthExpenseRepository;
import com.felipehogrefe.expenses.repositories.SourceExpenseRepository;

@SpringBootApplication
public class ExpensesApplication implements CommandLineRunner {
	private static final int querySize = 100, limit = 200;
	private static boolean isTest = false;
	// 94178
	
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private CategoryExpenseRepository categoryExpenseRepository;
	@Autowired
	private SourceExpenseRepository sourceExpenseRepository;
	@Autowired
	private MonthExpenseRepository monthExpenseRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(!isTest) {
		EventQueue.invokeLater(() -> {
			ExpensesGetter eg = new ExpensesGetter(querySize, expenseRepository, categoryExpenseRepository,
					sourceExpenseRepository, monthExpenseRepository);
			eg.getExpenses(limit);
		});
		}
	}
	
	public static int getLimit() {
		return limit;
	}
}

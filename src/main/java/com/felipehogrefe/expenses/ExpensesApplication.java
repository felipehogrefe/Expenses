package com.felipehogrefe.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipehogrefe.expenses.repositories.ExpenseRepository;

@SpringBootApplication
public class ExpensesApplication implements CommandLineRunner{
	private static final String url = "http://dados.recife.pe.gov.br/api/action/datastore_search?resource_id=d4d8a7f0-d4be-4397-b950-f0c991438111";
	private static final boolean limit = true;
	private static final int limitTotal = 5;
	
	@Autowired
	private ExpenseRepository expenseRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UrlToExpensesParser utep = new UrlToExpensesParser(url+(limit?("&limit="+limitTotal):""));
		expenseRepository.saveAll(utep.getExpenses());
	}
}

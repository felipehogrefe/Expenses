package com.felipehogrefe.gamesranking;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipehogrefe.gamesranking.domain.Expense;
import com.felipehogrefe.gamesranking.repositories.ExpenseRepository;

@SpringBootApplication
public class GamesRankingApplication implements CommandLineRunner{
	
	@Autowired
	private ExpenseRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(GamesRankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
	}
}

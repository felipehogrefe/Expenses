package com.felipehogrefe.gamesranking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipehogrefe.gamesranking.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}

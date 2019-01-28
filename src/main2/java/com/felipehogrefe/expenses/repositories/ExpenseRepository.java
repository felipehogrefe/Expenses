package com.felipehogrefe.expenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipehogrefe.expenses.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}

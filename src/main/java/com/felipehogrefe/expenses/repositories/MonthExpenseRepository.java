package com.felipehogrefe.expenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.felipehogrefe.expenses.domain.MonthExpense;

@Repository
public interface MonthExpenseRepository extends JpaRepository<MonthExpense, Integer>{

}

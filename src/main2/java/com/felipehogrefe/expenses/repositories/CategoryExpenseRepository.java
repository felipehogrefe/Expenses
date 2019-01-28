package com.felipehogrefe.expenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.felipehogrefe.expenses.domain.CategoryExpense;

@Repository
public interface CategoryExpenseRepository extends JpaRepository<CategoryExpense, Integer>{

}

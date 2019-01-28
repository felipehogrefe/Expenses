package com.felipehogrefe.expenses.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felipehogrefe.expenses.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	@Query(value = "SELECT * FROM EXPENSE WHERE FONTE_RECURSO_CODIGO  = ?1", nativeQuery = true)
	List<Expense> findBySourceCode(Integer code);

}

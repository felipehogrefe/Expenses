package com.felipehogrefe.expenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.felipehogrefe.expenses.domain.SourceExpense;

@Repository
public interface SourceExpenseRepository extends JpaRepository<SourceExpense, Integer>{

}

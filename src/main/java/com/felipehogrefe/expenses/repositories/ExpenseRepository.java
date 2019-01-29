package com.felipehogrefe.expenses.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipehogrefe.expenses.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	@Query(value = "SELECT * FROM EXPENSE WHERE FONTE_RECURSO_CODIGO  = ?1", nativeQuery = true)
	List<Expense> findBySourceCode(Integer code);
	
	List<Expense> findByOrgaoCodigo(Integer code);
	List<Expense> findByUnidadeCodigo(Integer code);
	List<Expense> findByCategoriaEconomicaCodigo(Integer code);
	List<Expense> findByGrupoDespesaCodigo(Integer code);
	List<Expense> findByModalidadeAplicacaoCodigo(Integer code);
	List<Expense> findByElementoCodigo(Integer code);
	List<Expense> findBySubelementoCodigo(Integer code);
	List<Expense> findByFuncaoCodigo(Integer code);
	List<Expense> findBySubfuncaoCodigo(Integer code);
	List<Expense> findByProgramaCodigo(Integer code);
	List<Expense> findByAcaoCodigo(Integer code);
	List<Expense> findByFonteRecursoCodigo(Integer code);
	List<Expense> findByEmpenhoModalidadeCodigo(Integer code);
	List<Expense> findByCredorCodigo(Integer code);
	List<Expense> findByModalidadeLicitacaoCodigo(Integer code);

}

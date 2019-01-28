package com.felipehogrefe.expenses;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.felipehogrefe.expenses.domain.CategoryExpense;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.domain.MonthExpense;
import com.felipehogrefe.expenses.domain.SourceExpense;
import com.felipehogrefe.expenses.repositories.CategoryExpenseRepository;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.felipehogrefe.expenses.repositories.MonthExpenseRepository;
import com.felipehogrefe.expenses.repositories.SourceExpenseRepository;
import com.felipehogrefe.expenses.services.ExpenseService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests extends TestCase {
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private CategoryExpenseRepository categoryExpenseRepository;
	@Autowired
	private SourceExpenseRepository sourceExpenseRepository;
	@Autowired
	private MonthExpenseRepository monthExpenseRepository;
	@Autowired
	private ExpenseService expenseService;

	Expense e1, e2, e3;
	List<Expense> localExpenses;
	static boolean setUpIsDone = false;

	@Test
	public void getExpenseListUsingChunks() {
		List<Expense> list = expenseService.getExpenseListChunk(0);
		assertTrue(list.size() == localExpenses.size());

	}

	@Test
	public void checkGetExpenseByAtributeCode() {
		List<String> atributesList = expenseService.getAtributesNamesList();
		for (String s : atributesList) {
			List<Expense> list = expenseService.getExpenseListByCode(s, 1);
			assertTrue(list.size() == 1);
		}
	}

	@Test
	public void checkCategoryValues() {
		assertTrue(categoryExpenseRepository.findById(1).get().getTotal() == 1.0);
		assertTrue(categoryExpenseRepository.findById(2).get().getTotal() == 2.0);
		assertTrue(categoryExpenseRepository.findById(3).get().getTotal() == 3.0);
	}

	@Test
	public void checkCategoryElementsPresent() {
		assertTrue(categoryExpenseRepository.findAll().size() == 3);
	}

	@Test
	public void checkAtributesNames() {
		assertTrue(expenseService.getAtributesNames().split(",").length == 15);
	}

	@Test
	public void removeExpense() {
		Expense e = expenseRepository.findAll().get(0);
		expenseService.removeExpense(e);
		assertFalse(expenseRepository.findById(e.getId()).isPresent());
		expenseService.editExpense(e);
	}

	@Test
	public void removeExpenseAndCheckTotals() {
		List<Expense> list = expenseRepository.findAll();
		for (Expense e : list) {
			expenseService.removeExpense(e);
		}

		double total = 0;
		for (CategoryExpense ce : categoryExpenseRepository.findAll()) {
			total += ce.getTotal();
		}
		assertTrue(total == 0);

		total = 0;
		for (MonthExpense me : monthExpenseRepository.findAll()) {
			total += me.getTotal();
		}
		assertTrue(total == 0);

		total = 0;
		for (SourceExpense se : sourceExpenseRepository.findAll()) {
			total += se.getTotal();
		}
		assertTrue(total == 0);

		for (Expense e : list) {
			expenseService.editExpense(e);
		}
	}

	@Before
	public void setUp() {
		if (setUpIsDone) {
			return;
		}
		init();
		setUpIsDone = true;
	}

	private void init() {
		e1 = new Expense();
		e1.set_id(1);
		e1.setAcao_codigo(1);
		e1.setAcao_nome("1");
		e1.setAno_movimentacao(2018);
		e1.setCategoria_economica_codigo(1);
		e1.setCategoria_economica_nome("1");
		e1.setCredor_codigo(1);
		e1.setCredor_nome("1");
		e1.setElemento_codigo(1);
		e1.setElemento_nome("1");
		e1.setEmpenho_ano(1);
		e1.setEmpenho_modalidade_codigo(1);
		e1.setEmpenho_modalidade_nome("1");
		e1.setEmpenho_numero(1);
		e1.setFonte_recurso_codigo(1);
		e1.setFonte_recurso_nome("1");
		e1.setFuncao_codigo(1);
		e1.setFuncao_nome("1");
		e1.setGrupo_despesa_codigo(1);
		e1.setGrupo_despesa_nome("1");
		e1.setIndicador_subempenho("1");
		e1.setMes_movimentacao(1);
		e1.setModalidade_aplicacao_codigo(1);
		e1.setModalidade_aplicacao_nome("1");
		e1.setModalidade_licitacao_codigo(1);
		e1.setModalidade_licitacao_nome("1");
		e1.setOrgao_codigo(1);
		e1.setOrgao_nome("1");
		e1.setPrograma_codigo(1);
		e1.setPrograma_nome("1");
		e1.setPrograma_codigo(1);
		e1.setPrograma_nome("1");
		e1.setSubelemento_codigo(1);
		e1.setSubelemento_nome("1");
		e1.setSubempenho(1);
		e1.setSubfuncao_codigo(1);
		e1.setSubfuncao_nome("1");
		e1.setUnidade_codigo(1);
		e1.setUnidade_nome("1");
		e1.setValor_empenhado("1");
		e1.setValor_liquidado("1");
		e1.setValor_pago("1");

		e2 = new Expense();
		e2.set_id(2);
		e2.setAcao_codigo(2);
		e2.setAcao_nome("2");
		e2.setAno_movimentacao(2028);
		e2.setCategoria_economica_codigo(2);
		e2.setCategoria_economica_nome("2");
		e2.setCredor_codigo(2);
		e2.setCredor_nome("2");
		e2.setElemento_codigo(2);
		e2.setElemento_nome("2");
		e2.setEmpenho_ano(2);
		e2.setEmpenho_modalidade_codigo(2);
		e2.setEmpenho_modalidade_nome("2");
		e2.setEmpenho_numero(2);
		e2.setFonte_recurso_codigo(2);
		e2.setFonte_recurso_nome("2");
		e2.setFuncao_codigo(2);
		e2.setFuncao_nome("2");
		e2.setGrupo_despesa_codigo(2);
		e2.setGrupo_despesa_nome("2");
		e2.setIndicador_subempenho("2");
		e2.setMes_movimentacao(2);
		e2.setModalidade_aplicacao_codigo(2);
		e2.setModalidade_aplicacao_nome("2");
		e2.setModalidade_licitacao_codigo(2);
		e2.setModalidade_licitacao_nome("2");
		e2.setOrgao_codigo(2);
		e2.setOrgao_nome("2");
		e2.setPrograma_codigo(2);
		e2.setPrograma_nome("2");
		e2.setPrograma_codigo(2);
		e2.setPrograma_nome("2");
		e2.setSubelemento_codigo(2);
		e2.setSubelemento_nome("2");
		e2.setSubempenho(2);
		e2.setSubfuncao_codigo(2);
		e2.setSubfuncao_nome("2");
		e2.setUnidade_codigo(2);
		e2.setUnidade_nome("2");
		e2.setValor_empenhado("2");
		e2.setValor_liquidado("2");
		e2.setValor_pago("2");

		e3 = new Expense();
		e3.set_id(3);
		e3.setAcao_codigo(3);
		e3.setAcao_nome("3");
		e3.setAno_movimentacao(3038);
		e3.setCategoria_economica_codigo(3);
		e3.setCategoria_economica_nome("3");
		e3.setCredor_codigo(3);
		e3.setCredor_nome("3");
		e3.setElemento_codigo(3);
		e3.setElemento_nome("3");
		e3.setEmpenho_ano(3);
		e3.setEmpenho_modalidade_codigo(3);
		e3.setEmpenho_modalidade_nome("3");
		e3.setEmpenho_numero(3);
		e3.setFonte_recurso_codigo(3);
		e3.setFonte_recurso_nome("3");
		e3.setFuncao_codigo(3);
		e3.setFuncao_nome("3");
		e3.setGrupo_despesa_codigo(3);
		e3.setGrupo_despesa_nome("3");
		e3.setIndicador_subempenho("3");
		e3.setMes_movimentacao(3);
		e3.setModalidade_aplicacao_codigo(3);
		e3.setModalidade_aplicacao_nome("3");
		e3.setModalidade_licitacao_codigo(3);
		e3.setModalidade_licitacao_nome("3");
		e3.setOrgao_codigo(3);
		e3.setOrgao_nome("3");
		e3.setPrograma_codigo(3);
		e3.setPrograma_nome("3");
		e3.setPrograma_codigo(3);
		e3.setPrograma_nome("3");
		e3.setSubelemento_codigo(3);
		e3.setSubelemento_nome("3");
		e3.setSubempenho(3);
		e3.setSubfuncao_codigo(3);
		e3.setSubfuncao_nome("3");
		e3.setUnidade_codigo(3);
		e3.setUnidade_nome("3");
		e3.setValor_empenhado("3");
		e3.setValor_liquidado("3");
		e3.setValor_pago("3");

		List<Expense> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		localExpenses = list;

		expenseRepository.saveAll(list);

		expenseService.defineTotals(list);
	}
}

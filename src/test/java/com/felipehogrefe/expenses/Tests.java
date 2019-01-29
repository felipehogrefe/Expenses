package com.felipehogrefe.expenses;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.felipehogrefe.expenses.domain.CategoryExpense;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.domain.MonthExpense;
import com.felipehogrefe.expenses.domain.SourceExpense;
import com.felipehogrefe.expenses.resources.CategoryExpenseResource;
import com.felipehogrefe.expenses.resources.ExpenseResource;
import com.felipehogrefe.expenses.resources.MonthExpenseResource;
import com.felipehogrefe.expenses.resources.SourceExpenseResource;
import com.felipehogrefe.expenses.services.CategoryExpenseService;
import com.felipehogrefe.expenses.services.ExpenseService;
import com.felipehogrefe.expenses.services.MonthExpenseService;
import com.felipehogrefe.expenses.services.SourceExpenseService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests extends TestCase {
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private CategoryExpenseService categoryExpenseService;
	@Autowired
	private MonthExpenseService monthExpenseService;
	@Autowired
	private SourceExpenseService sourceExpenseService;
	@Autowired
	private ExpenseResource expenseResource;  
	@Autowired
	private CategoryExpenseResource categoryExpenseResource;  
	@Autowired
	private MonthExpenseResource monthExpenseResource;  
	@Autowired
	private SourceExpenseResource sourceExpenseResource;  

	Expense e1, e2, e3;
	static boolean setUpIsDone = false;
	
	@Test
	public void removeExpenseFromResource() {
		Expense e = expenseService.getExpenseList().get(0);
		assertTrue(expenseResource.removeExpense(e.getId()).getStatusCodeValue()==200);
		assertFalse(expenseService.find(e.getId()).isPresent());
		expenseService.addExpense(e);
	}
	@Test
	public void removeInexistingExpenseFromResource() {
		assertTrue(expenseResource.removeExpense(-10).getStatusCodeValue()==400);
	}
	@Test
	public void findExpense() {
		assertTrue(expenseResource.find(1).getStatusCodeValue()==200);		
	}
	@Test
	public void findInexistingExpense() {
		assertTrue(expenseResource.find(-10).getStatusCodeValue()==404);		
	}
	@Test
	public void checkGetAtributesNamesReturnCode() {
		ResponseEntity<List<String>> response = expenseResource.getAtributesNames();
		assertTrue(response.getStatusCodeValue()==200);		
		List<String> list = response.getBody();
		assertTrue(list.size()==15);		
	}
	
	@Test
	public void checkIfGetByCodeRetrievesOkforAtributesNamesList() {
		for(String s : expenseService.getCodeAtributesNamesList()) {
			assertTrue(expenseResource.getByCodigo(s, 1).getStatusCodeValue()==200);
		}
	}
	
	@Test
	public void checkGetByCodeWithWrongFieldName() {
		assertTrue(expenseResource.getByCodigo("any_field", 1).getStatusCodeValue()==400);
	}
	
	@Test
	public void checkGetByCodeWithInexistingCode() {
		assertTrue(expenseResource.getByCodigo("fonte_recurso_codigo", -10).getBody().size()==0);
	}
	
	@Test
	public void getChunkBeyondTheData() {
		assertTrue(expenseResource.findAll(4).getStatusCodeValue()==400);
	}
	
	@Test
	public void getFirstChunk() {
		assertTrue(expenseResource.findAll(0).getStatusCodeValue()==200);	
	}
	
	@Test
	public void checkSourceFindResource() {
		assertTrue(sourceExpenseResource.find(1).getStatusCodeValue()==200);
		assertTrue(sourceExpenseResource.find(-10).getStatusCodeValue()==404);
	}
	@Test
	public void checkSourceGetCompleteList() {
		assertTrue(sourceExpenseResource.findAll().getStatusCodeValue()==200);
	}
	@Test
	public void checkMonthFindResource() {
		assertTrue(monthExpenseResource.find(1).getStatusCodeValue()==200);
		assertTrue(monthExpenseResource.find(-10).getStatusCodeValue()==404);
	}
	@Test
	public void checkMonthGetCompleteList() {
		assertTrue(monthExpenseResource.findAll().getStatusCodeValue()==200);
	}
	@Test
	public void checkCategoryFindResource() {
		assertTrue(categoryExpenseResource.find(1).getStatusCodeValue()==200);
		assertTrue(categoryExpenseResource.find(-10).getStatusCodeValue()==404);
	}
	@Test
	public void checkCategoryGetCompleteList() {
		assertTrue(categoryExpenseResource.findAll().getStatusCodeValue()==200);
	}
	
	@Test
	public void checkIfAllCodeAtributesAreRetrieved() {
		List<String> codeAtributes = new ArrayList<String>();
		codeAtributes.add("orgao_codigo");
		codeAtributes.add("unidade_codigo");
		codeAtributes.add("categoria_economica_codigo");
		codeAtributes.add("grupo_despesa_codigo");
		codeAtributes.add("modalidade_aplicacao_codigo");
		codeAtributes.add("elemento_codigo");
		codeAtributes.add("subelemento_codigo");
		codeAtributes.add("funcao_codigo");
		codeAtributes.add("subfuncao_codigo");
		codeAtributes.add("programa_codigo");
		codeAtributes.add("acao_codigo");
		codeAtributes.add("fonte_recurso_codigo");
		codeAtributes.add("empenho_modalidade_codigo");
		codeAtributes.add("credor_codigo");
		codeAtributes.add("modalidade_licitacao_codigo");
		
		List<String> list = expenseService.getCodeAtributesNamesList();
		list.retainAll(codeAtributes);
		assertTrue(list.size()==codeAtributes.size());
	}
	
	@Test
	public void checkCompleteList() {
		assertTrue(expenseService.getExpenseList().size()==3);
	}
	
	@Test
	public void checkSourceAvailableCodes() {
		List<Integer> codes = new ArrayList<>();
		for(int i = 1;i<=3;i++) codes.add(i);
		List<Integer> availableCodes = expenseService.getSourcesAvailableCodes();
		int initialSize = availableCodes.size();
		availableCodes.retainAll(codes);
		assertTrue(availableCodes.size()==initialSize);
	}

	@Test
	public void getExpenseListUsingChunks() {
		List<Expense> list = expenseService.getExpenseListChunk(0);
		assertTrue(list.size() == 3);
	}

	@Test
	public void checkGetExpenseByAtributeCode() {
		List<String> atributesList = expenseService.getCodeAtributesNamesList();
		for (String s : atributesList) {
			System.out.println(s);
			List<Expense> list = expenseService.getExpenseListByCode(s, 2);			
			assertTrue(list.size() == 1);
		}
	}

	@Test
	public void checkSourceValues() {
		assertTrue(sourceExpenseService.find(1).get().getTotal() == 1.0);
		assertTrue(sourceExpenseService.find(2).get().getTotal() == 2.0);
		assertTrue(sourceExpenseService.find(3).get().getTotal() == 3.0);
	}
	
	@Test
	public void checkSourceElementsPresent() {
		assertTrue(sourceExpenseService.getCompleteList().size() == 3);
	}
	
	@Test
	public void checkMonthValues() {
		assertTrue(monthExpenseService.find(1).get().getTotal() == 1.0);
		assertTrue(monthExpenseService.find(2).get().getTotal() == 2.0);
		assertTrue(monthExpenseService.find(3).get().getTotal() == 3.0);
	}

	@Test
	public void checkMonthElementsPresent() {
		assertTrue(monthExpenseService.getCompleteList().size() == 3);
	}

	@Test
	public void checkCategoryValues() {
		assertTrue(categoryExpenseService.find(1).get().getTotal() == 1.0);
		assertTrue(categoryExpenseService.find(2).get().getTotal() == 2.0);
		assertTrue(categoryExpenseService.find(3).get().getTotal() == 3.0);
	}

	@Test
	public void checkCategoryElementsPresent() {
		assertTrue(categoryExpenseService.getCompleteList().size() == 3);
	}

	@Test
	public void checkAtributesNames() {
		assertTrue(expenseService.getAtributesNames().split(",").length == 15);
	}

	@Test
	public void removeExpense() {
		Expense e = expenseService.getExpenseList().get(0);
		expenseService.removeExpense(e);
		assertFalse(expenseService.find(e.getId()).isPresent());
		expenseService.addExpense(e);
	}

	@Test
	public void removeExpenseAndCheckTotals() {
		List<Expense> list = expenseService.getExpenseList();
		for (Expense e : list) {
			expenseService.removeExpense(e);
		}

		double total = 0;
		for (CategoryExpense ce : categoryExpenseService.getCompleteList()) {
			total += ce.getTotal();
		}
		assertTrue(total == 0);

		total = 0;
		for (MonthExpense me : monthExpenseService.getCompleteList()) {
			total += me.getTotal();
		}
		assertTrue(total == 0);

		total = 0;
		for (SourceExpense se : sourceExpenseService.getCompleteList()) {
			total += se.getTotal();
		}
		assertTrue(total == 0);

		for (Expense e : list) {
			expenseService.addExpense(e);
		}
	}
	
	@Test
	public void editExpenseAndCheckTotals() {
		List<Expense> list = expenseService.getExpenseList();
		for (Expense e : list) {
			e.setValor_pago(""+Double.parseDouble(e.getValor_pago().replace(",","."))*10);			
			e.setValor_liquidado(""+Double.parseDouble(e.getValor_liquidado().replace(",","."))*10);			
			e.setValor_empenhado(""+Double.parseDouble(e.getValor_empenhado().replace(",","."))*10);			
			expenseService.editExpense(e);
		}

		double total = 0;
		for (CategoryExpense ce : categoryExpenseService.getCompleteList()) {
			total += ce.getTotal();
		}
		assertTrue(total == 60);

		total = 0;
		for (MonthExpense me : monthExpenseService.getCompleteList()) {
			total += me.getTotal();
		}
		assertTrue(total == 60);

		total = 0;
		for (SourceExpense se : sourceExpenseService.getCompleteList()) {
			total += se.getTotal();
		}
		assertTrue(total == 60);

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
		e1.setValor_liquidado("1");
		e1.setValor_pago("1");
		e1.setValor_empenhado("1");
		e1.setUnidade_codigo(1);
		e1.setUnidade_nome("1");

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

		expenseService.saveAll(list);
		
		expenseService.defineTotals(list);
	}
}

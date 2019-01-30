package com.felipehogrefe.expenses.services;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.expenses.domain.Expense;
import com.felipehogrefe.expenses.repositories.ExpenseRepository;
import com.google.gson.Gson;

@Service
public class ExpenseService {
	private static final int chunkSize = 10;
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private MonthExpenseService monthExpenseService;
	@Autowired
	private CategoryExpenseService categoryExpenseService;
	@Autowired
	private SourceExpenseService sourceExpenseService;
	
	private static final String sufix = "findBy";

	public Optional<Expense> find(Integer id) {
		Optional<Expense> obj = expenseRepository.findById(id);
		return obj;
	}

	/**
	 * @return A list containing all expenses in the database.
	 */
	public List<Expense> getExpenseList() {
		return expenseRepository.findAll();
	}

	/**
	 * Saves the given expense in the database and edits the totals of the
	 * CategoryExpense, MonthExpense and SourceExpense totals.
	 * @param e The edited expense.
	 * @return
	 */
	public boolean editExpense(Expense e) {
		Optional<Expense> oldExpense = find(e.getId());
		if (oldExpense.isPresent()) {
			if (expenseRepository.save(e) != null) {
				double newValue = Double.parseDouble(e.getValor_liquidado().replace(",", "."))
						- Double.parseDouble(oldExpense.get().getValor_liquidado().replace(",", "."));
				editTotals(newValue, e);
				return true;
			}

		}
		return false;
	}

	/**
	 * Insert the expense in the database, and edits the totals of the
	 * CategoryExpense, MonthExpense and SourceExpense totals. 
	 * @param e The expense to be inserted.
	 * @return
	 */
	public boolean addExpense(Expense e) {
		if (expenseRepository.save(e) != null) {
			addTotals(e);
			return true;
		}
		return false;
	}

	/**
	 * Gets a chunk of expenses, starting at the (chunk * chunkSize) element of the database until the (chunk * chunkSize + chunkSize), 
	 * notice that the number of elements are defined by the chunkSize
	 * @param chunk The chunk to be retrieved.
	 * @return A List with of expenses, the size of the list is defined by chunkSize.
	 */
	public List<Expense> getExpenseListChunk(int chunk) {
		List<Expense> list = new ArrayList<Expense>();
		List<Expense> expenseList = expenseRepository.findAll();
		int index = chunk * chunkSize;
		if (index >= expenseList.size())
			return null;
		//We need a check for the last chunk, the size o expenseList might not be a multiple of chunkSize
		while (list.size() < chunkSize && list.size() < (expenseList.size())) {
			Expense e = expenseList.get(index++);
			list.add(e);
		}
		return list;
	}

	/**
	 * Removes the expense from the database, and edits the totals of the
	 * CategoryExpense, MonthExpense and SourceExpense totals. 
	 * 
	 * @param e The expense to be removed.
	 */
	public void removeExpense(Expense e) {
		removeFromDB(e);
		expenseRepository.delete(e);

	}
	
	/**
	 * Given a field name search the database for occurrences of expense with field value equals to code.
	 * @param fieldName
	 * @param code
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Expense> getExpenseListByCode(String fieldName, Integer code) {
		List<Expense> list = new ArrayList<Expense>();
		try {
			Method m = ExpenseRepository.class.getMethod(getCorrespondingMethodName(fieldName), Integer.class);
			list = (List<Expense>) m.invoke(expenseRepository, code);
//			if (fieldName.equals("fonteRecursoCodigo")) {
//				list = expenseRepository.findBySourceCode(code);
//			}
//			else {
//				//TODO 
//				List<Expense> completeList = expenseRepository.findAll();
//				for (Expense e : completeList) {
//					if ((int) Expense.class.getField(fieldName).get(e) == code)
//						list.add(e);
//				}
//			}
		} catch (IllegalArgumentException  |SecurityException e) {
			e.printStackTrace();
		}  catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		} 
		return list;
	}

	private String getCorrespondingMethodName(String fieldName) {
		String methodName = sufix+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1,fieldName.length());
		return methodName;
	}

	public String getAtributesNames() {
		String json = new Gson().toJson(getCodeAtributesNamesList());
		return json;
	}

	public List<String> getCodeAtributesNamesList() {
		Field[] fields = Expense.class.getFields();
		List<String> list = new ArrayList<>();
		for (Field f : fields) {
			if (f.getName().contains("Codigo")) {
				list.add(f.getName());
			}
		}

		return list;
	}

	private void removeFromDB(Expense e) {
		monthExpenseService.remove(e);
		categoryExpenseService.remove(e);
		sourceExpenseService.remove(e);
	}

	public void defineTotals(List<Expense> list) {
		for (Expense e : list) {
			double expenseValue = Double.parseDouble(e.getValor_liquidado().replace(",", "."));

			categoryExpenseService.editCategory(e, expenseValue);
			monthExpenseService.editMonth(e, expenseValue);
			sourceExpenseService.editSource(e, expenseValue);
		}
	}

	private void addTotals(Expense expense) {
		editTotals(Double.parseDouble(expense.getValor_liquidado().replace(",", ".")), expense);
	}

	private void editTotals(Double expenseValue, Expense expense) {
		categoryExpenseService.editCategory(expense, expenseValue);
		monthExpenseService.editMonth(expense, expenseValue);
		sourceExpenseService.editSource(expense, expenseValue);
	}

	public List<Integer> getSourcesAvailableCodes() {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> hash = new HashSet<Integer>();

		List<Expense> completeList = expenseRepository.findAll();
		for (Expense e : completeList) {
			hash.add(e.getFonte_recurso_codigo());
		}
		list.addAll(hash);
		return list;
	}

	public void saveAll(List<Expense> list) {
		expenseRepository.saveAll(list);
	}
}

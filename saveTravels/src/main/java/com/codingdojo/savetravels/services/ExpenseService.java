package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	// returns all expenses
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	// creates an expense
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	// finds one expense
	public Expense findExpenseById(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		return optionalExpense.isPresent() ? optionalExpense.get() : null;
	}
	
	// updates an expense
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	// deletes an expense
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}

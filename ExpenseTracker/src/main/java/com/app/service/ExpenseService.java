package com.app.service;

import java.util.List;

import com.app.pojo.Expense;
import com.app.pojo.User;

public interface ExpenseService {

	 	Expense saveExpense(Expense expense);
	 	Expense getExpenseByUserId(int expenseId);
	    //void deleteExpense(Long expenseId);
	    List<Expense> getExpensesByUser(User user);
	    List<Expense> getAllExpenses();
}

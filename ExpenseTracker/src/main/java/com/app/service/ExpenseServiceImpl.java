package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ExpenseRepository;
import com.app.pojo.Expense;
import com.app.pojo.User;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepository;
	

	
	@Override
	public Expense saveExpense(Expense expense) {
		// TODO Auto-generated method stub
		return expenseRepository.save(expense);
	}

//	@Override
//	public void deleteExpense(int expenseId) {
//		expenseRepository.deleteById(expenseId);
//	}

	@Override
	public List<Expense> getExpensesByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> getAllExpenses() {
		// TODO Auto-generated method stub
		return expenseRepository.findAll();
	}

	@Override
	public Expense getExpenseByUserId(int expenseId) {
		// TODO Auto-generated method stub
		return expenseRepository.findById(expenseId).get();
	}

}

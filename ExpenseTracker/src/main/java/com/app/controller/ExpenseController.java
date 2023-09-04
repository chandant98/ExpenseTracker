package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Expense;
import com.app.pojo.User;
import com.app.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	  @PostMapping("/register")
	    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
	        Expense createdExpense = expenseService.saveExpense(expense);
	        return ResponseEntity.ok(createdExpense);
	    }

	    @PutMapping("/{expenseId}")
	    public ResponseEntity<Expense> updateExpense(@PathVariable Long expenseId, @RequestBody Expense expense) {
	        Expense updatedExpense = expenseService.saveExpense(expense);
	        return ResponseEntity.ok(updatedExpense);
	    }

//	    @DeleteMapping("/{expenseId}")
//	    public ResponseEntity<String> deleteExpense(@PathVariable Long expenseId) {
//	        expenseService.deleteExpense(expenseId);
//	        return ResponseEntity.ok("Expense deleted successfully.");
//	    }
	    @GetMapping
		public ResponseEntity<?> getAllUser() {
			System.out.println("in fetch all expenses");
			List<Expense> expenseList = expenseService.getAllExpenses();
			// chk if empty
			if (expenseList.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// non empty list
			return new ResponseEntity<>(expenseList, HttpStatus.OK);
	    }
		@GetMapping({"/{expenseId}"})
		public ResponseEntity<?> getUserById(@PathVariable int expenseId) {
			System.out.println("in get expense dtls " + expenseId);
			try {
				return ResponseEntity.ok(expenseService.getExpenseByUserId(expenseId));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}

package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}

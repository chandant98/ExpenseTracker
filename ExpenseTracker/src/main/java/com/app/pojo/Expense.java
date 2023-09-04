package com.app.pojo;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Expense {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseId;
    
	private String description;
    
    private double amount;
    
    private LocalDate date;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Category category;
    
    public Expense() {
    	
    }

	public Expense(String description, double amount, LocalDate date, User user, Category category) {
		super();
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.user = user;
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
    
 
	
    
    
}

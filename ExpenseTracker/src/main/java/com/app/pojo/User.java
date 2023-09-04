package com.app.pojo;

import java.util.ArrayList;
import java.util.List;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String password;
	private String role;
	
	@OneToMany
	private List<Expense> expenses=new ArrayList<>();
	
	public User() {
		
	}

	public User(String name, String password, String role, List<Expense> expenses) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
		this.expenses = expenses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", role=" + role + ", expenses="
				+ expenses + "]";
	}
	
	
	
	
}

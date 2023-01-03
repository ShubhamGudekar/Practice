package com.main;

import java.time.LocalDate;

public class BankAccount {
	private int acctNo;
	private String name;
	private String email;
	private double balance;
	private LocalDate dateOfCreation;
	private AccountType acctType;
	
	public BankAccount(int acctNo, String name, String email, double balance, LocalDate dateOfCreation,
			AccountType acctType) {
		this.acctNo = acctNo;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.dateOfCreation = dateOfCreation;
		this.acctType = acctType;
	}

	public int getAcctNo() {
		return acctNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAcctType() {
		return acctType.toString();
	}

	public void setAcctType(AccountType acctType) {
		this.acctType = acctType;
	}

	
	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", name=" + name + ", email=" + email + ", balance=" + balance
				+ ", dateOfCreation=" + dateOfCreation + ", acctType=" + acctType + "]";
	}

	
	
	
	
	
	
	
}

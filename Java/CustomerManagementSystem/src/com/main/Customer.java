package com.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer implements Comparable<Customer> {
	private int id;
	private String name;
	private String email;
	private String password;
	private double registrationAmount;
	private Date dateOfBirth;
	private ServicePlan plan;
	private static int custIdCounter;
	public static SimpleDateFormat sdf;

	static {
		custIdCounter = 100;
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public Customer(String Email) {
		this.email = Email;
	}

	public Customer(String name, String email, String password, ServicePlan plan, Date dob) {
		id = custIdCounter;
		this.name = name;
		this.email = email;
		this.password = password;
		this.plan = plan;
		this.registrationAmount = plan.getPlanCost();
		this.dateOfBirth = dob;
		custIdCounter++;
	}

	@Override
	public String toString() {
		return String.format("[Id : %-3d|Name : %-15s|Email : %-20s|DOB : %-10s|Plan : %-10s ", id, name, email,
				sdf.format(dateOfBirth), plan) + "|Amount :" + registrationAmount;
	}

	@Override
	public boolean equals(Object anotherCustomer) {
		if (anotherCustomer instanceof Customer) {
			if (this.email.equals(((Customer) anotherCustomer).email))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Customer anotherCustomer) {
		return this.email.compareTo(anotherCustomer.email);
	}

	public int getId() {
		return id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
		this.registrationAmount=plan.getPlanCost();
	}
}

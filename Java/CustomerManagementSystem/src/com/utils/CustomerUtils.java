package com.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.custom_exceptions.CustomerException;
import com.main.Customer;
import com.main.ServicePlan;

import static com.main.Customer.sdf;
import static com.utils.Validations.*;

public class CustomerUtils {

	public static void addEntries(ArrayList<Customer> tempData) throws ParseException {
		tempData.add(new Customer("shubham", "shubham@gmail.com", "Shubham@123", ServicePlan.PLATINUM,
				sdf.parse("16-01-1981")));
		tempData.add(new Customer("sagar", "sagar@gmail.com", "Sagar#987sagar", ServicePlan.SILVER,
				sdf.parse("10-08-1982")));
		tempData.add(new Customer("abhishek", "abhishek@gmail.com", "Abhishek@12", ServicePlan.GOLD,
				sdf.parse("20-07-1983")));
		tempData.add(new Customer("ram", "ram@gmail.com", "Ram&784", ServicePlan.DIAMOND, sdf.parse("21-02-1984")));
		tempData.add(
				new Customer("sourav", "sourav@gmail.com", "Sourav@13", ServicePlan.PLATINUM, sdf.parse("29-03-1985")));
		tempData.add(new Customer("saswade", "saswade@gmail.com", "Saswade@12", ServicePlan.SILVER,
				sdf.parse("07-04-1986")));
		tempData.add(
				new Customer("rishal", "rishal@gmail.com", "rishal@145", ServicePlan.DIAMOND, sdf.parse("24-05-1989")));
		tempData.add(new Customer("yash", "yash@gmail.com", "Yash$369", ServicePlan.PLATINUM, sdf.parse("05-06-1990")));
	}

	public static Customer findByEmail(String email, List<Customer> custData) throws CustomerException {
		Customer tempCust = new Customer(email);
		int index = custData.indexOf(tempCust);
		if (index == -1)
			throw new CustomerException("Invalid Email");
		return custData.get(index);
	}

	public static Customer custLogin(String email, String password, List<Customer> custData) throws CustomerException {
		Customer custTemp = findByEmail(emailValidation(email), custData);
		if (custTemp.getPassword().equals(password))
			return custTemp;
		throw new CustomerException("Invalid Password");
	}

	public static boolean resetPassword(String email, String oldPassword, String newPassword, List<Customer> custData)
			throws CustomerException {
		Customer tempCust = findByEmail(email, custData);
		if (tempCust.getPassword().equals(oldPassword)) {
			tempCust.setPassword(passwordValidation(newPassword));
			return true;
		}
		throw new CustomerException("Invalid Password");
	}

	public static void displayPlanDetails() {
		for (ServicePlan sp : ServicePlan.values())
			System.out.println(String.format("Plan : %-10sCost : ", sp) + sp.getPlanCost() + " Rs");
	}

	public static void updatePlan(List<Customer> tempData, String oldsp, String newsp) throws CustomerException {
		ServicePlan s = planValidation(oldsp);
		for (Customer tempCust : tempData)
			if (tempCust.getPlan().equals(s))
				tempCust.setPlan(planValidation(newsp));
	}
}

package com.utils;

import static com.main.Customer.sdf;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.custom_exceptions.CustomerException;
import com.main.Customer;
import com.main.ServicePlan;

public class Validations {
	public static String emailValidation(String email) throws CustomerException {
		if (email.contains("@") && (email.endsWith(".com") || email.endsWith(".org"))) {
			return email;
		}
		throw new CustomerException("Please Enter valid Email Id");
	}

	private static String checkForDupEmail(String email, List<Customer> custData) throws CustomerException {
		Customer tempCust = new Customer(email);
		if (custData.contains(tempCust))
			throw new CustomerException("Email Id already Registered");
		return email;
	}

	public static String passwordValidation(String password) throws CustomerException {
		String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%]).{4,10}";
		if (password.matches(passwordPattern))
			return password;
		throw new CustomerException("Please Enter valid Password");
	}

	private static Date dateOfBirthValidation(Date dob) throws ParseException, CustomerException {
		if (dob.before(sdf.parse("01-01-1995")))
			return dob;
		throw new CustomerException("Please Enter Valid Date");
	}

	public static ServicePlan planValidation(String tempPlan) throws CustomerException {
		try {
			return ServicePlan.valueOf(tempPlan.toUpperCase());
		} catch (IllegalArgumentException e) {
			StringBuilder sb = new StringBuilder("Available Plans \n ");
			sb.append(Arrays.toString(ServicePlan.values()) + "\nChoose correct Plan");
			throw new CustomerException(sb.toString());
		}
	}

	public static Customer validateData(String name, String email, String password, String plan, Date dob,
			List<Customer> custData) throws CustomerException, ParseException {
		return new Customer(name, checkForDupEmail(emailValidation(email), custData), passwordValidation(password),
				planValidation(plan), dateOfBirthValidation(dob));
	}

}

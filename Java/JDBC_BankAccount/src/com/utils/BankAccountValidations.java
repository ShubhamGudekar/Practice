package com.utils;

import com.main.AccountType;

import customException.BankAccountException;

public class BankAccountValidations {

	public static AccountType validateAccType(String accType) {
		return AccountType.valueOf(accType.toUpperCase());
}
	
	public static double validateAmount(double amount) throws BankAccountException
	{
		if(0>=amount)
			throw new BankAccountException("Enter Proper Amount\nTransaction Declicned");
		return amount;
	}
	
	public static String validateEmail(String email) throws BankAccountException {
		String pattern = "^[\\w\\.-]+@[\\w\\.-]+(com|org|net)$";
		if (email.matches(pattern))
			return email;
		throw new BankAccountException("Please Enter valid Email Id");
	}
	
}

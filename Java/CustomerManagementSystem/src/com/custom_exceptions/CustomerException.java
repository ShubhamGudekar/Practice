package com.custom_exceptions;

@SuppressWarnings("serial")
public class CustomerException extends Exception {

	public CustomerException(String msg) {
		super(msg);
	}
}

package com.Validations;

import com.customException.LibraryException;
import com.main.Category;

public class LibraryValidations {

	public static byte login(String username, String password) throws LibraryException {
		if (username.equals("admin") && password.equals("admin1234"))
			return 1;
		if (username.equals("reader") && password.equals("reader1234"))
			return 2;
		throw new LibraryException("Invalid Login Credentials");
	}

	public static Category validateCategory(String category) {
		return Category.valueOf(category.toUpperCase());
	}
}

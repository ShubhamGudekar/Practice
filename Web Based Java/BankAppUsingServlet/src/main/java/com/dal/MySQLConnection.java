package com.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	private static Connection con;
	
	static {
		try {
			System.out.println("connecting db");
			con = DriverManager.getConnection("jdbc:mysql:http://localhost:3306/BankApplication","root","root123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
}

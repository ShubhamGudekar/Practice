package com.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import customException.BankAccountException;
import static com.utils.BankAccountValidations.*;

public class DbUtils {

	public static Connection con;

	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void displayAcctDetails() throws SQLException {
		String sqlQuery = "SELECT * FROM bankAccount";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlQuery);
		// CallableStatement cs = con.prepareCall("call displayData");
		// ResultSet rs = cs.executeQuery();
		System.out.printf("%-8s%-20s%-20s%-12s%-10s%s\n", "AcctNo", "Name", "Email", "Balance", "Acct Type",
				"Acct Open Date");
		while (rs.next()) {
			System.out.printf("%-8d%-20s%-20s%-12.2f%-10s%s\n", rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getDouble(4), rs.getString(5), rs.getDate(6));
		}
		rs.close();
	}

	public static boolean findAccount(int accNo) throws SQLException, BankAccountException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM BankAccount where accNo=?");
		ps.setInt(1, accNo);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			if (accNo == rs.getInt(1))
				return true;
		}
		throw new BankAccountException("Account Not Found");
	}

	public static double fetchBalance(int accNo) throws SQLException, BankAccountException {
		findAccount(accNo);
		CallableStatement cs = con.prepareCall("call getBalance(?,?)");
		cs.setInt(1, accNo);
		cs.executeQuery();
		return cs.getDouble(2);
	}

	public static void moneyTransfer(int sourceAccNo, int destAccNo, double amount)
			throws SQLException, BankAccountException {
		withdrawBalance(sourceAccNo, amount);
		depositBalance(destAccNo, amount);

	}

	public static double withdrawBalance(int accNo, double amount) throws SQLException, BankAccountException {
		findAccount(accNo);
		CallableStatement cs = con.prepareCall("call withdrawAmount(?,?,?)");
		cs.setInt(1, accNo);
		cs.setDouble(2, validateAmount(amount));
		cs.executeUpdate();
		return cs.getDouble(3);
	}

	public static double depositBalance(int accNo, double amount) throws SQLException, BankAccountException {
		findAccount(accNo);
		CallableStatement cs = con.prepareCall("call depositAmount(?,?,?)");
		cs.setInt(1, accNo);
		cs.setDouble(2, validateAmount(amount));
		cs.executeUpdate();
		return cs.getDouble(3);
	}

	public static void insertBankAccount(String name, String email, double balance, String acctType)
			throws SQLException, BankAccountException {
		CallableStatement cs = con.prepareCall("call insertAccount(?,?,?,?)");
		validateAccType(acctType);
		cs.setString(1, name.toUpperCase());
		cs.setString(2, validateEmail(email).toUpperCase());
		cs.setDouble(3, balance);
		cs.setString(4, acctType.toUpperCase());
		int i = cs.executeUpdate();
		if (i == 0)
			throw new BankAccountException("Data Not Inserted");
		System.out.println("Data inserted Successfully");
	}

	public static void deleteBankAccount(int accno) throws SQLException, BankAccountException {
		findAccount(accno);
		CallableStatement cs = con.prepareCall("call deleteAccount(?)");
		cs.setInt(1, accno);
		cs.executeUpdate();
		System.out.println("Account deleted Successfully");
	}

	public static void updateBankAccountName(int accNo, String name) throws SQLException, BankAccountException {
		findAccount(accNo);
		PreparedStatement pstmt = con.prepareStatement("update bankaccount set name=? where acctNo=?");
		pstmt.setString(1, (name.toUpperCase()));
		pstmt.setInt(2, accNo);
		int i = pstmt.executeUpdate();
		if (i == 0)
			throw new BankAccountException("Name not Updated");
		System.out.println("Account Name updatated Successfully");
	}

	public static void updateBankAccountEmail(int accNo, String email) throws SQLException, BankAccountException {
		findAccount(accNo);
		PreparedStatement pstmt = con.prepareStatement("update bankaccount set email=? where acctNo=?");
		pstmt.setString(1, email.toUpperCase());
		pstmt.setInt(2, accNo);
		int i = pstmt.executeUpdate();
		if (i == 0)
			throw new BankAccountException("Email not Updated");
		System.out.println("Account Email updatated Successfully");
	}
	
}

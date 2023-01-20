package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pojo.User;

public class DbUtils {

	public int registerAccount(User newUser) throws SQLException {
		Connection con = MySQLConnection.getCon();
		PreparedStatement ps = con.prepareStatement("INSERT INTO NETBANKING VALUES (?,MD5(?))");
		ps.setString(1, newUser.getUsername());
		ps.setString(2, newUser.getPassword());
		return ps.executeUpdate();
	}

	public List<User> getAllUser() throws SQLException {
		List<User> userData = new ArrayList<User>();
		Connection con = MySQLConnection.getCon();
		Statement s = con.createStatement();
		ResultSet result = s.executeQuery("SELECT * FROM NETBANKING");
		while (result.next()) {
			userData.add(new User(result.getString(1), result.getString(2)));
		}
		return userData;
	}

	public User findUser(String username,String password) throws SQLException {
		User foundUser=null;
		Connection con = MySQLConnection.getCon();
		PreparedStatement ps = con.prepareStatement("INSERT INTO NETBANKING VALUES (?,MD5(?))");
		ps.setString(1,username);
		ps.setString(2, password);
		System.out.println(username +" "+password);
		ResultSet result = ps.executeQuery();
		if(result.next()) {
			foundUser = new User(result.getString(1), result.getString(1));
			System.out.println(foundUser);
		}
		return foundUser;	
	}
}

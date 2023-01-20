package com.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dal.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget");
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		p.write("<center>\r\n"
				+ "			<form method=\"post\" action=\"Login\">\r\n"
				+ "				<h1>Login</h1>\r\n"
				+ "				<p>Email : <input type=\"email\" name=\"email\" id=\"email\" /></p>\r\n"
				+ "				<p>Password : <input type=\"password\" name=\"password\" id=\"password\" /></p>\r\n"
				+ "				<input type=\"submit\" value=\"submit\" />\r\n"
				+ "			</form>\r\n"
				+ "		</center>");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		System.out.println("in service method");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
		System.out.println("in parent service method");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("in init");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in dopost method");
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		System.out.println(email +" " +password);
		DbUtils db= new DbUtils();
		try {
			User tempUser =db.findUser(email, password);
			if(tempUser!=null) {
				PrintWriter p = response.getWriter();
				p.write("<h1>Welcome"+ email +" </h1>");
			}
			else {
				response.sendRedirect("Login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException("SQL EXception");
		}
		
	}

}

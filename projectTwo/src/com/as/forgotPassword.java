package com.as;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/forgotPassword")

public class forgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		System.out.println("inside forgot password");
		RequestDispatcher rs1 = request.getRequestDispatcher("/html/forgotPassword.html");
		rs1.include(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	String newPassword = request.getParameter("newPassword");
	String confirmPassword = request.getParameter("confirmPassword");
	if (newPassword == confirmPassword)
	{
	try {
		String driver = "com.mysql.jdbc.driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String pwd = "root";
		Class.forName(driver);
		HttpSession session = request.getSession(true);
		String id = (String)session.getAttribute("id");
		
		Connection conn = DriverManager.getConnection(url,username,pwd);
		
		PreparedStatement update = conn.prepareStatement("update register set password=? where id =?");
		update.setString(1,newPassword);
		update.setInt(2, 0);
		update.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	else {
		System.out.println("entered passwords are not matching");
	}
	}
}

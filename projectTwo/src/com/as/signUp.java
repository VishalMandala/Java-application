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

@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	response.setContentType("text/html");
		System.out.println("inside signUp Controller");
		 RequestDispatcher rs = request.getRequestDispatcher("/html/signUp.html");
         rs.include(request, response);*/
		doPost(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("inside register post");
		String userName = request.getParameter("userName");
		
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String designation = request.getParameter("designation");
		String role = request.getParameter("role");
		String salary = request.getParameter("salary");
		String emailId = request.getParameter("emailId");
		String contactDetails = request.getParameter("contactDetails");
		int intAge = Integer.valueOf(age);
		float floatSalary = Float.valueOf(salary);
		try {
			
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String pwd = "root";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,pwd);
			
			PreparedStatement create = conn.prepareStatement("insert into register values(0,?,?,?,?,?,?,?,?,?,?,?)");
			create.setString(1,userName);
			create.setString(2,password);
			create.setString(3,firstName);
			create.setString(4,middleName);
			create.setString(5,lastName);
			create.setInt(6,intAge);
			create.setString(7,designation);
			create.setString(8,role);
			create.setFloat(9,floatSalary);
			create.setString(10,emailId);
			create.setString(11,contactDetails);
			create.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rs4 = request.getRequestDispatcher("/html/login.html");
		rs4.forward(request, response);
	}			

}

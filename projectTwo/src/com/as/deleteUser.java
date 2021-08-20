package com.as;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	System.out.println("inside doget");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emailId= request.getParameter("emailId");
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		out.println("inside delete user");
		System.out.println("before try");
		try{
			System.out.println("inside try");
			String Driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localHost:3306/test";
			String userName = "root";
			String pwd = "root";
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(url,userName,pwd);
			PreparedStatement delete = conn.prepareStatement("DELETE FROM register where emailId =?");
			delete.setString(1,emailId);
			delete.executeUpdate();

			RequestDispatcher rs22 = request.getRequestDispatcher("/html/deletedUser.html"); 
			rs22.forward(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

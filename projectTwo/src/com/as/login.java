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
import javax.servlet.http.HttpSession;

@WebServlet("/login")

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String emailId = request.getParameter("emailId");
	String password = request.getParameter("password");
	
	response.setContentType("text/html");
	
	
	try{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String pwd = "root";
		Class.forName(driver);
		int id = 0;
		Connection conn = DriverManager.getConnection(url,username,pwd);
		
		PreparedStatement check = conn.prepareStatement("SELECT id FROM register where emailId=? and password =?");
		check.setString(1,emailId);
		check.setString(2,password);
		
		ResultSet rs2 = check.executeQuery();
		while(rs2.next())
		{
			id = (int)rs2.getInt(1);
		}
		if(id == 0)
		{
			HttpSession session=request.getSession();
			session.setAttribute("errorId",false); 
		RequestDispatcher rs21 = request.getRequestDispatcher("/html/login.jsp"); 
		rs21.forward(request, response);
		

		/*RequestDispatcher rsError = request.getRequestDispatcher("/html/error.html"); 
		rsError.include(request, response);*/
		
		}
		else{
			HttpSession session=request.getSession();
			session.setAttribute("loggedUserId", id);

			RequestDispatcher rs21 = request.getRequestDispatcher("/html/homePage.html"); 
			rs21.forward(request, response);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	//PrintWriter out = response.getWriter();
	
	//out.println("<h2>" +emailId +"</h2>" );
	//out.println("<h2>" +password +"</h2>" );
	
	}
}

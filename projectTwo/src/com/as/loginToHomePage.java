package com.as;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/loginToHomePage")
public class loginToHomePage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		int id =(int)session.getAttribute("loggedUserId");
		PrintWriter out = response.getWriter();		
		out.println("id is"+id);
		String firstName ="";
		String middleName ="";
        String lastName = "";
        int age=0;
        String designation ="";
        String role = "";
        int salary = 0;
        String emailId = "";
        String contactDetails = "" ;
		
		try
		{		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String pwd = "root";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,pwd);
		PreparedStatement read =  conn.prepareStatement("Select * FROM register where id = ?");
		read.setInt(1,id);
		
		ResultSet rs = read.executeQuery();
		
		while (rs.next())
		{
			id = (int)rs.getInt(1);
			firstName = rs.getString(4);
			middleName = rs.getString(5);
			lastName = rs.getString(6);
			age = rs.getInt(7);
			designation = rs.getString(8);
        	role =rs.getString(9);
        	salary = rs.getInt(10);
        	emailId = rs.getString(11);
        	contactDetails = rs.getString(12);	
		}
		if (id == 0)
		{
			RequestDispatcher rs2 = request.getRequestDispatcher("/html/login.html");
		}else{
			System.out.println("hello");
		/*	List<firstName> register = new ArrayList<firstName>();
			List<middleName> register = new ArrayList<middleName>(); 
			List<lastName> register = new ArrayList<lastName>(); 
			List<age> register = new ArrayList<age>(); 
			List<designation> register = new ArrayList<designation>(); 
			List<firstName> register = new ArrayList<role>(); 
			List<firstName> register = new ArrayList<>(); 
			List<firstName> register = new ArrayList<>(); 
			List<firstName> register = new ArrayList<>(); */
			out.println("<table border=1 style='width:100%'><tr><th>Firstname</th><th>Middle Name</th><th>Lastname</th><th>Age</th><th>Designation</th><th>Role</th><th>Salary</th><th>Email Id</th><th>Contact Details</th></tr><br>");	
			out.println("<tr><td>"+firstName+"</td>"); 
			out.println("<td>"+middleName+"</td>");
			out.println("<td>"+lastName+"</td>");
			out.println("<td>"+age+"</td>");
			out.println("<td>"+designation+"</td>");
			out.println("<td>"+role+"</td>");
			out.println("<td>"+salary+"</td>");
			out.println("<td>"+emailId+"</td>");
			out.println("<td>"+contactDetails+"</td><tr><br>");		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

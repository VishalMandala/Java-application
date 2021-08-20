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
@WebServlet("/updatedDetails")
public class updatedDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		System.out.println("inside update Details controler.");
		
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String designation = request.getParameter("designation");
		String role = request.getParameter("role");
		String salary = request.getParameter("salary");
		String emailId = request.getParameter("emailId");
		String contactDetails = request.getParameter("contactDetails");
		
		System.out.println(firstName+"     "+age);
		PrintWriter out = response.getWriter();	
		int intAge = Integer.valueOf(age);
		float floatSalary = Float.valueOf(salary);
		
		try{
			
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String pwd = "root";
			Class.forName(driver);
			HttpSession session=request.getSession(false);
			int id =(int)session.getAttribute("loggedUserId");
			Connection conn = DriverManager.getConnection(url,username,pwd);
			
			PreparedStatement edit = conn.prepareStatement("update register set firstName=?,middleName=?,LastName=?,age=?,designation=?,role=?,salary=?,emailId=?,contactDetails=?  where id =?");
			edit.setInt(10,id);
			edit.setString(1, firstName);
			edit.setString(2, middleName);
			edit.setString(3, lastName);
			edit.setInt(4, intAge);
			edit.setString(5, designation);
			edit.setString(6, role);
			edit.setFloat(7, floatSalary);
			edit.setString(8, emailId);
			edit.setString(9, contactDetails);
			
			edit.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		out.println("<table border=1 style='width:100%'><tr><th>Firstname</th><th>Middle Name</th><th>Lastname</th><th>Age</th><th>Designation</th><th>Role</th><th>Salary</th><th>Email Id</th><th>Contact Details</th></tr><br>");	
		out.println("<tr><td>"+firstName+"</td>"); 
		out.println("<td>"+middleName+"</td>");
		out.println("<td>"+lastName+"</td>");
		out.println("<td>"+age+"</td>");
		out.println("<td>"+designation+"</td>");
		out.println("<td>"+role+"</td>");
		out.println("<td>"+salary+"</td>");
		out.println("<td>"+emailId+"</td>");
		out.println("<td>"+contactDetails+"</td><tr><br>");
	
		 
	}

}

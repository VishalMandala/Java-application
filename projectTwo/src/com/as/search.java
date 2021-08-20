package com.as;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside search controller");
		String search = request.getParameter("Search");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstName ="";
		String middleName ="";
        String lastName = "";
        int age=0;
        String designation ="";
        String role = "";
        int salary = 0;
        String emailId = "";
        String contactDetails = "" ;
		
        
		try{
			out.println("<head><meta charset='utf-8'><meta name='viewport' content='width=device-width,initial-scale=1'><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'></head><body>");
			out.println("<div class='container'><ul class='pagination'><li class='active'><a href='active'>1</a></li><li><a href='active'>2</a></li><li><a href='active'>3</a></li><li><a href='active'>4</a></li><li><a href='active'>5</a></li></ul></div>");
			out.println("<select name='example_length' aria-controls='example' class='form-control input'><option value='5'>5</option><option value='10'>10</option><option value='15'>15</option></select>");
			out.println("<table border=1 style='width:100%'><tr><th>Firstname</th><th>Middle Name</th><th>Lastname</th><th>Age</th><th>Designation</th><th>Role</th><th>Salary</th><th>Email Id</th><th>Contact Details</th></tr><br>");
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String pwd = "root";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,pwd);
			PreparedStatement searching = conn.prepareStatement("SELECT * FROM register where firstName like '%"+search+"%' OR lastName like '%"+search+"%' OR middleName like '%"+search+"%' OR designation like '%"+search+"%' OR age like '%"+search+"%'OR salary like '%"+search+"%' OR emailId like '%"+search+"%' OR contactDetails like '%"+search+"%'");
			//searching.setString(1,search);
			ResultSet rs3 =searching.executeQuery();
			
			while(rs3.next()){
				
				firstName = rs3.getString(4);
				middleName = rs3.getString(5);
				lastName = rs3.getString(6);
				age = rs3.getInt(7);
				designation = rs3.getString(8);	
	        	role =rs3.getString(9);
	        	salary = rs3.getInt(10);
	        	emailId = rs3.getString(11);
	        	contactDetails = rs3.getString(12);	
	        	
	        	
	        	out.println("<tr><td>"+firstName+"</td>"); 
				out.println("<td>"+middleName+"</td>");
				out.println("<td>"+lastName+"</td>");
				out.println("<td>"+age+"</td>");
				out.println("<td>"+designation+"</td>");
				out.println("<td>"+role+"</td>");
				out.println("<td>"+salary+"</td>");
				out.println("<td>"+emailId+"</td>");
				out.println("<td>"+contactDetails+"</td><tr><br></body>");
			}
				
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
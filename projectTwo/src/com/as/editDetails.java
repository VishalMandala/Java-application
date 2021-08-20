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
import javax.servlet.http.HttpSession;

@WebServlet("/editDetails")
public class editDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		HttpSession session=request.getSession(false);
		int id =(int)session.getAttribute("loggedUserId");
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
		PreparedStatement edit =  conn.prepareStatement("Select * FROM register where id =?");
		edit.setInt(1,id);
		
		ResultSet rs = edit.executeQuery();
		while(rs.next())
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
	}	
		catch(Exception e){
			e.printStackTrace();
		}
		out.println("<form method='POST' action='/projectTwo/updatedDetails'>");
		out.println("<label for='firstName'>First Name</label><input type='text' name='firstName'  value='"+firstName+"'>" +"<br><br>");
		out.println("<label for='middleName' >Middle Name</label><input type='text' name='middleName' value='"+middleName+"'>" +"<br><br>");
		out.println("<label for='lastName' >Last Name</label><input type='text' name='lastName' value='"+lastName+"'>" +"<br><br>");
		out.println("<label for='age' >Age</label><input type='text' name='age' value='"+age+"'>" +"<br><br>");
		out.println("<label for='designation' >Designation</label><input type='text' name='designation' value='"+designation+"'>" +"<br><br>");
		out.println("<label for='role' >Role</label><input type='text' name='role' value='"+role+"'>" +"<br><br>");
		out.println("<label for='salary' >Salary</label><input type='text' name='salary' value='"+salary+"'>" +"<br><br>");
		out.println("<label for='emailId' >Email ID</label><input type='text' name='emailId' value='"+emailId+"'>" +"<br><br>");
		out.println("<label for='contactDetails' >Contact Details</label><input type='text' name='contactDetails' value='"+contactDetails+"'>" +"<br><br>");
		
		
		
		
		out.println("<button type='submit'>Submit</button>");
		out.println("</form>");
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

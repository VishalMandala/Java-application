package com.as;

import java.io.IOException;
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


@WebServlet("/forgotPwd")
public class forgotPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName1 = request.getParameter("userName1");
		response.setContentType("text/html");
		try {
			String driver = "com.mysql.jdbc.driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String pwd = "root";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,pwd);
			int id =0;

			PreparedStatement update = conn.prepareStatement("SELECT id FROM register where userName = ?");
			update.setString(1, userName1);
			ResultSet rs= update.executeQuery();
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			while(rs.next())
			{
				
				id=(int)rs.getInt(0);
				
			}
			if(id ==0)
			{
			RequestDispatcher rs2 = request.getRequestDispatcher("/html/forgotPwd.html"); 
			rs2.forward(request, response);
			}
			else{
				
				RequestDispatcher rs2 = request.getRequestDispatcher("/html/forgotPassword.html"); 
				rs2.forward(request, response);
			}
			
	/*		for(id = 1 ;id < 100 ;id++){
				if (userName == userName1)
				{
					System.out.println("inside forgotPWD");
					RequestDispatcher rs2 = request.getRequestDispatcher("/html/forgotPwd.html"); 
					
				}
				else{
					System.out.println("user name does not exists");
				}
				response.sendRedirect("/projectTwo/forgotPassword.html");  

			}*/
			
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		}
}



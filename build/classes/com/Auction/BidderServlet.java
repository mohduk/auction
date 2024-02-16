package com.Auction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class BidderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		

		String name=request.getParameter("name");
		String lname=request.getParameter("lname");
		String number=request.getParameter("number");
		String email =request.getParameter("email");
	    String password =request.getParameter("password");
		
		RequestDispatcher dispatcher=null;
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bider",
										 "root","root");
			
			PrintWriter out=response.getWriter();
			out.print(name);
			out.print( lname);
			out.print(number);
			out.print(email);
			out.print(password);
			
			
				
				PreparedStatement pst=con
						.prepareStatement("insert into auction(name, lname,number,email,password) values(?,?,?,?,?)");

				
				pst.setString(1, name);
				pst.setString(2, lname);
				pst.setString(3,number);
				pst.setString(4, email);
				pst.setString(5, password);
				

				
				int rowCount=pst.executeUpdate();
				dispatcher=request.getRequestDispatcher("BidderRegistration.jsp");
				if(rowCount>0)
				{
					request.setAttribute("status", "success");
				}
				else
				{
					request.setAttribute("status", "failed");
				}
				
					dispatcher.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			finally
			{
				try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		}
		
		}
		
	}

	


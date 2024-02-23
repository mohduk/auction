package com.servlet.register;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.db.ConnectionProvider;

@WebServlet("/bidder")
public class BidderRegistrationServlet extends HttpServlet{
	
	private static String insert="insert into bidder(b_name, email, p_no) values(?, ?, ?)";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		
		resp.setContentType("text/html");
		
		String name=req.getParameter("b_name");
		String email=req.getParameter("email");
		String no=req.getParameter("p_no");
		
		System.out.println("Bidder name : "+name);
		System.out.println("Bidder email : "+email);
		System.out.println("Bidder Phone Number : "+no);
		
		try {
			Connection con=ConnectionProvider.getConnection();
			
			PreparedStatement pstmt=con.prepareStatement(insert);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, no);
			
			int count=pstmt.executeUpdate();
			
			if(count==0) {
				System.out.println("Bidder Not Register.");
			}else {
				System.out.println("Bidder Register succesfully...");
			}
			
			pw.print("Bidder Register succesfully....");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//send redirect 
		resp.sendRedirect("Home.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}

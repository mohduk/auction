package com.servlet.register;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.db.ConnectionProvider;


@WebServlet("/SellerServlet")
public class SellerServlet extends HttpServlet {
	
	private static String insert="insert into seller(s_name, s_lname, email, pno) values(?, ?, ?, ?)";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		String name=req.getParameter("s_name");
		String lname=req.getParameter("s_lname");
		String email=req.getParameter("email");
		String pno=req.getParameter("pno");
		
		System.out.println("Seller Name :"+name);
		System.out.println("Seller Last Name :"+lname);
		System.out.println("Email :"+email);
		System.out.println("Phone Number :"+pno);
		
		try {
			
			Connection con=ConnectionProvider.getConnection();
			
			PreparedStatement pstmt=con.prepareStatement(insert);
			pstmt.setString(1, name);
			pstmt.setString(2, lname);
			pstmt.setString(3, email);
			pstmt.setString(4, pno);
			
			int count=pstmt.executeUpdate();
			
			if(count==0) {
				System.out.println("Seller Not Register");
			}else {
				System.out.println("Seller Register Succesfully...");
			}
			
			pw.print("Seller Register Succesfully...");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//send redirect 
		res.sendRedirect("Home.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.db.ConnectionProvider;


@WebServlet("/SupplierRegistrationServlet")
public class SupplierRegistrationServlet extends HttpServlet {
       
	private static String insert="insert into supplier(s_name, s_lname, p_no, email) values(?, ?, ?, ?)";
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String name=req.getParameter("name");
		String lname=req.getParameter("lname");
		String no=req.getParameter("number");
		String email=req.getParameter("email");
		
		System.out.println("Supplier name : "+name);
		System.out.println("Supplier Last name : "+lname);
		System.out.println("Supplier Phone Number : "+no);
		System.out.println("Supplier email : "+email);		
		
		try {
			
			Connection con=ConnectionProvider.getConnection();
			PreparedStatement pstmt=con.prepareStatement(insert);
			
			pstmt.setString(1, name);
			pstmt.setString(2, lname);
			pstmt.setString(3, no);
			pstmt.setString(4, email);
			
			int count=pstmt.executeUpdate();
			
			if(count==0) {
				System.out.println("Supplier Not Register.");
				pw.print("Supplier Register succesfully....");
			}else {
				System.out.println("Supplier Register succesfully...");
			}
			
			con.close();
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
 
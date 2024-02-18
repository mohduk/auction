package com.servlet.register;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.db.ConnectionProvider;

@WebServlet("/addProduct")
public class ProductServlet extends HttpServlet{
	
	private static String insert="insert into product(p_name,base_price) values (?, ?)";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw= res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read the form values
		String name=req.getParameter("p_name");
		String price=req.getParameter("b_price");
		
		System.out.println("name :"+name);
		System.out.println("price :"+price);
		
		
		try {
			
			Connection con=ConnectionProvider.getConnection();
			
			PreparedStatement pstmt=con.prepareStatement(insert);
			pstmt.setString(1, name);
			pstmt.setString(2, price);
			
			int count=pstmt.executeUpdate();
			
			if(count==0) {
				System.out.println("Product Not Inserted.");
			}else {
				System.out.println("Product Inserted Succesfully...");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		pw.print("Product Add succesfully");
		
		//send redirect 
		res.sendRedirect("Home.html");
		
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}


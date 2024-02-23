package com.mypack.db;

import java.sql.*;

public class ConnectionProvider {
	
	public static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/auction";
			String username="root";
			String password="Root@123";
			
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	

}

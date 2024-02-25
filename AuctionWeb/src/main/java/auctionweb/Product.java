package auctionweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		String product_name = request.getParameter("product_name");
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String product_color = request.getParameter("product_color");
		String product_model = request.getParameter("product_model");
		String product_price = request.getParameter("product_price");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","Abhi@123");
			 
			

		    String query = "INSERT INTO product_details(product_name, product_id, product_color, product_model, product_price) VALUES (?, ?, ?, ?, ?)";
		    try (PreparedStatement pst = con.prepareStatement(query)) {
		        pst.setString(1, product_name);
		        pst.setInt(2, product_id);  // Change here to setInt
		        pst.setString(3, product_color);
		        pst.setString(4, product_model);
		        pst.setString(5, product_price);

		        int rowAffected = pst.executeUpdate();

		        if (rowAffected != 0) {
		            out.print("<h1>Record Inserted Successfully</h1>");
		        } else {
		            out.print("<h1>Record not Inserted</h1>");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        out.print("<h1> an error occur : " + e.getMessage() + "</h1>");
		    } finally {
		        try {
		            con.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		} catch (ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		    out.print("<h1> An error occurred: " + e.getMessage() + "</h1>");
		}
	}
			
	
	}
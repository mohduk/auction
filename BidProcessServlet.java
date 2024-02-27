package com.AuctionServ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BidProcessServlet")
public class BidProcessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bidderId = request.getParameter("bidder_id");
        String productId = request.getParameter("product_id");
        String bidAmountString = request.getParameter("bid_amount");

        PrintWriter out = response.getWriter();
        Connection con = null;

        try {
            con = DBConnectivity.getConnect();

            double basePrice = getBasePrice(con, productId);
            double bidAmount = Double.parseDouble(bidAmountString);

            if (bidAmount >= basePrice) {
                insertBid(con, bidderId, productId, bidAmount);
                out.print("<h1>Bid Successfully</h1>");
            } else {
                out.print("<h1>Bid failed. Bid amount must be greater than or equal to the base price.</h1>");
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            out.print("<h1>An error occurred: you have inserted wrong info</h1>");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private double getBasePrice(Connection con, String productId) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement("SELECT base_price FROM product WHERE product_id = ?")) {
            pst.setString(1, productId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("base_price");
                }
            }
        }
        return 0.0; // Default value or handle case when base price retrieval fails
    }

    private void insertBid(Connection con, String bidderId, String productId, double bidAmount) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement("INSERT INTO bid(bidder_id, product_id, bid_amount) VALUES (?, ?, ?)")) {
            pst.setString(1, bidderId);
            pst.setString(2, productId);
            pst.setDouble(3, bidAmount);
            pst.executeUpdate();
        }
    }
}

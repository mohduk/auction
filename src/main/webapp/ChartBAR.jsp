<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bid Details</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        #chart-container {
            width: 80%; /* Adjust the width as needed */
            max-width: 600px;
        }
    </style>
</head>
<body>

<canvas id="myChart" style="width:100%;max-width:600px"></canvas>

<%
    try {
        // Establish the database connection
        String url = "jdbc:mysql://localhost:3306/auction";
        String user = "root";
        String password = "Nick@0167";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);

        // Query to fetch data from the database
        String sql = "SELECT bidder_id, bid_amount FROM bid";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Process the result set and populate arrays
        ArrayList<String> bidderIds = new ArrayList<>();
        ArrayList<Integer> bidAmounts = new ArrayList<>();

        while (resultSet.next()) {
            bidderIds.add(resultSet.getString("bidder_id"));
            bidAmounts.add(resultSet.getInt("bid_amount"));
        }

        // Close database resources
        resultSet.close();
        statement.close();
        connection.close();

        // Convert ArrayLists to arrays for Chart.js
        String[] bidderIdsArray = bidderIds.toArray(new String[0]);
        Integer[] bidAmountsArray = bidAmounts.toArray(new Integer[0]);
%>

<script>
    const bidderIds = <%= Arrays.toString(bidderIdsArray) %>;
    const bidAmounts = <%= Arrays.toString(bidAmountsArray) %>;
    const barColors = ["red", "green", "blue", "orange", "brown"];

    new Chart("myChart", {
        type: "bar",
        data: {
            labels: bidderIds,
            datasets: [{
                backgroundColor: barColors,
                data: bidAmounts
            }]
        },
        options: {
            legend: {display: false},
            title: {
                display: true,
                text: "Bid Amounts by Bidder"
            }
        }
    });
</script>

<%
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

</body>
</html>

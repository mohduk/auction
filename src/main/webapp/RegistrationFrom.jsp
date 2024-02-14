
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
</head>

<body class="body">
<h2>Registration</h2>
<div class="center">
<form  action="RegistrationServlet" method="get">
<label>Name:</label><br>
<input  type="text" name="name" placeholder="name "><br>
<label>LastName:</label><br>
<input type="text" name="lname" placeholder=" lname"><br>
<label>Mobile No:</label><br>
<input type="number" name="number" placeholder="number "><br>
<label>Email:</label><br>
<input type="email" name="email" placeholder=" email"><br>
<label>Password:</label><br>
<input type="password" name="password" placeholder="*******"><br><br>
<input type="submit" value="submit">

</form>
</div>
</body>
</html>
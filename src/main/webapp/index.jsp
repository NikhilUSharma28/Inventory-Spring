<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="/products/login" method="post">
		<h1>Login</h1>
		<label>Email Id: </label> <input type="email" name="email"required="required" /><br>
		<br> <label>Password: </label> <input type="password" name="pass" required="required" /><br>
		<br> <input type="submit" value="Login" /><br>
		<br>
	</form>
	<a href="/products/register">Register</a>
</body>
</html>
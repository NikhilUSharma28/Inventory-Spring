<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="saveuser" method="post">
		<h1>User Registration</h1>
		<br> <br> <label>First Name: </label> <input type="text"
			name="firstname" required="required" /><br> <br> <label>Last
			Name: </label> <input type="text" name="lastname" required="required" /><br>
		<br> <label>Email Id: </label> <input type="email" name="email"
			required="required" /><br> <br> <label>Password: </label>
		<input type="password" name="password" required="required" /><br>
		<br> <input type="submit" value="Submit" /><br> <br>
	</form>
	<a href="/products">Login</a>

	<!-- <label>Address Line 1:</label>
	<textarea rows="3" cols="10" name="address1" required="required"></textarea>
	<label>Address Line 2:</label>
	<textarea rows="3" cols="10" name="address2" required="required"></textarea>
	<label>Address Line 3:</label>
	<textarea rows="3" cols="10" name="address3" required="required"></textarea>
	<label>Pincode:</label>
	<input type="number" name="pincode" required="required" />
	<label>City:</label>
	<select name="city" id="city">
	</select>
	<label>State:</label>
	<select name="state" id="state">
	</select>
	<label>Country:</label>
	<select name="country" id="country">
	</select>
	<label>Type:</label>
	<select name="type" id="type">
	</select> -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="LoginRegister" method="post">
		<table
			style="background-color: #778899; margin-right: 20px; margin-left: 20px;">
			<tr>
				<td><h3 style="color: red;">${message}</h3>
					<h3 style="color: green;">${successMessage}</h3></td>
			</tr>
			<tr>
				<td><h2 style="color: red">Login Page!!!!</h2></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="username" required="required"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1" required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Login"></td>
				<td><a href="register.jsp">Registration </a></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>
	<form action="LoginRegister" method="post">
		<table
			style="background-color: skyblue; margin-right: 20px; margin-left: 20px;">
			<tr>
				<td><h2 style="color: black">Registration Page!!!!</h2></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>


			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td>Re-Type Password :</td>
				<td><input type="password" name="password2"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="register"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>
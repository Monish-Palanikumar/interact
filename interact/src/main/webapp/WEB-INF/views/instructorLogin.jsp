<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="/resources/styles/loginInstructor.css" rel="stylesheet">
</head>
<body>
	<div>
		<h1>Login to our application</h1>
		<form action="/instructor/validateInstructor" method="get">
			<table>
			<tr>
				<td><h3>Username:</h3></td>
				<td><input type="text" name="username" maxlength="30" autofocus required/></td>
			</tr>
			<tr>
				<td><h3>Password: </h3></td>
				<td><input type="password" name="password" maxlength="20" required /></td>
			</tr>
			<tr style="text-align:center">
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>

		</form>

	</div>
</body>
</html>
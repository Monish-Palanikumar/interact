<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="resources/styles/index.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Interact</title>
</head>
<body>
	<div id="main">
		<h1>Interact.</h1>
		<blockquote>Interaction is the key to overcome resistance and speed up changes -<cite> Marianne Williamson</cite></blockquote>
	</div>
	<h3>Please select your role</h3>
	<div id="buttons">
		<div id="stud">
			<form action="student" method="get">
				<input type="submit" value="Student" />
			</form>
		</div>
		<div id="ins">
			<form action="instructor" method="get">
				<input type="submit" value="Instructor" />
			</form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Instructor List</title>
</head>
<body>
	<div>
		<h2>List of instructors:</h2>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>

			<c:forEach items="${ins}" var="instructor">
				<tr>
					<td>${instructor.id}</td>
					<td>${instructor.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
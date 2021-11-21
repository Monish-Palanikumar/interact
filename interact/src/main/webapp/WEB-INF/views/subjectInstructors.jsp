<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/styles/instructors.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Instructors</title>
</head>
<body>
	<h1>Select an instructor from the list</h1>
		
	<c:forEach items="${instructors}" var="instructor">
		<div id="ins">
			<h4>Name: <span>${instructor.name}</span></h4>
			<h4>Experience: <span>${instructor.experience} years</span></h4>
			<h4>About: <span>${instructor.about}</span></h4>
			<h4>Rating: <span>${instructor.rating}</span></h4>
			<form method="GET" action="/student/book">
				<input type="hidden" name="id" value="${instructor.id}" />
				<input type="submit" value="Book" />
			</form> 
		</div>
		<br />
	</c:forEach>
</body>
</html>
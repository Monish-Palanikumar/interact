<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/resources/styles/instructorDashboard.css" />
</head>
<body>
	<h1>Hi ${instructor_name} !!</h1>
	<h1>Click the link below to access the schedule for today </h1>
	
	<div id="but">
			<a href="/instructor/getSchedule">See Schedule</a>
			<br /><br />
			<br />
			<a href="/instructor/logout">logout</a>
	</div>
</body>
</html>
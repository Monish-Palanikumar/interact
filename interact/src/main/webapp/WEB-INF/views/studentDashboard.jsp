<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/resources/styles/studentDashboard.css" />
</head>
<body>
	<h1>Hi ${student_name} !!</h1>
	<h1>Welcome to Interact. Happy Learning !</h1>
	<div id="contents">
		<div id="scheduleView">
			<h3>Schedule for your day</h3>
			<a id="refresh" href="/student/showDashboard">Refresh</a>
			<table id="schedule">
				<tr>
					<th>Sr. No.</th>
					<th>Instructor Name</th>
					<th>Start Time</th>
					<th>End Time</th>
				</tr>
				<c:set var="i" scope="session" value="0"/>
				<c:forEach items="${schedule}" var="schedule">
					<tr>
						<td>${i+1}</td>
						<td>${insList[i].name}</td>
						<td>${schedule.start}</td>
						<td>${schedule.end}</td>
					</tr>
				<c:set var="id" scope="session" value="${i=i+1}"/>  
		</c:forEach>
			</table>
		</div>
		<div id="but">
			<a href="/student/getSubjects">Select subject</a>
			<a href="/student/logout">logout</a>
		</div>
	</div>
</body>
</html>
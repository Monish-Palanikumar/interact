<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookings</title>
<link rel="stylesheet" href="/resources/styles/displayBookings.css" />
</head>
<body>
	<div>
		<h1>Commitments for your day</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>Student Name</th>
				<th>Student Contact Number</th>
				<th>Start Time</th>
				<th>End Time</th>
			</tr>
			<c:set var="i" scope="session" value="0"/>
			<c:forEach items="${bookings}" var="booking">
				<c:set var="id" scope="session" value="${booking.id}"/>  
				<tr>
					<td>${i+1}</td>
					<td>${stuList[i].name}</td>
					<td>${stuList[i].contactNumber}</td>
					<td>${booking.start}</td>
					<td>${booking.end}</td>
				</tr>
				<c:set var="id" scope="session" value="${i=i+1}"/> 
		</c:forEach>
		</table>
	</div>
</body>
</html>
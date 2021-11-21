<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book an instructor</title>
<link href="/resources/styles/booking.css" rel="stylesheet">
</head>
<body>
	<div>
		<h1>Confirm details and select a slot</h1>
		<div id="details">		
			<h4>Instructor Name: <span>${instructor.name}</span></h4>
			<form action="/student/confirm" method="GET">
				<input type="hidden" name="iid" value="${instructor.id}" />
				<input type="hidden" name="sid" value="${student.id}" />
				<h4>Available time slots: (HH:MM:SS)</h4>
				<c:forEach items="${timings}" var="timings">
					<span id="time">${timings.slot} </span>
				</c:forEach>
				<h4>Choose your time slot: (HH:MM:SS)</h4>
				<span>Start time: </span><input type="text" name="start" pattern="(?:[01]\d|2[0-3]):(?:[0-5]\d):(?:[0-5]\d)" autofocus required/>
				<span>End time: </span><input type="text" name="end" pattern="(?:[01]\d|2[0-3]):(?:[0-5]\d):(?:[0-5]\d)"  required/>
				<br /><br /><br />
				<input type="submit" value="Confirm" />
			</form>
		</div>
	</div>
</body>
</html>
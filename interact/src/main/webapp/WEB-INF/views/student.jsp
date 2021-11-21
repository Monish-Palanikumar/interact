<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject List</title>
<link rel="stylesheet" href="/resources/styles/subList.css" />
</head>
<body>
	<div id="subList">
		<h1>Select the subject for which you need guidance</h1>
		<table cellspacing="100" id="but">
			<tr>
				<td>
					<form action="/student/getInstructorsBySubject" method="GET">
						<input type="hidden" name="subject" value="Computer Science" />
						<input type="hidden" name="board" value="${student_board}" />
						<input type="hidden" name="grade" value="${student_grade}" />
						<input type="submit" value="Computer Science" />
					</form>
				</td>
				<td>
					<form action="/student/getInstructorsBySubject" method="GET">
						<input type="hidden" name="subject" value="Physics" /> 
						<input type="hidden" name="board" value="${student_board}" />
						<input type="hidden" name="grade" value="${student_grade}" />
						<input type="submit" value="Physics" />
					</form>
				</td>
				<td>
					<form action="/student/getInstructorsBySubject" method="GET">
						<input type="hidden" name="subject" value="Chemistry" /> 
						<input type="hidden" name="board" value="${student_board}" />
						<input type="hidden" name="grade" value="${student_grade}" />
						<input type="submit" value="Chemistry" />
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="/student/getInstructorsBySubject" method="GET">
						<input type="hidden" name="subject" value="Biology" /> 
						<input type="hidden" name="board" value="${student_board}" />
						<input type="hidden" name="grade" value="${student_grade}" />
						<input type="submit" value="Biology" />
					</form>
				</td>
				<td>
					<form action="/student/getInstructorsBySubject" method="GET">
						<input type="hidden" name="subject" value="Geography" /> 
						<input type="hidden" name="board" value="${student_board}" />
						<input type="hidden" name="grade" value="${student_grade}" />
						<input type="submit" value="Geography" />
					</form>
				</td>
				<td>
					<form action="/student/getInstructorsBySubject" method="GET">
						<input type="hidden" name="subject" value="History" /> 
						<input type="hidden" name="board" value="${student_board}" />
						<input type="hidden" name="grade" value="${student_grade}" />
						<input type="submit" value="History" />
					</form>
				</td>
			</tr>
		</table>

		<!-- 
		<form action="/student/getInstructorsByAvailability" method="GET">
			<input type="hidden" name="availability" value="Y" /> <input
				type="submit" value="get" />
		</form>
		-->
	</div>
</body>
</html>
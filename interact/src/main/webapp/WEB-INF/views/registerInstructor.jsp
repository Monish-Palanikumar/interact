<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="/resources/styles/registerInstructor.css" rel="stylesheet">
</head>
<body>
	<div>
		<form method="get" action="/instructor/register">
			<table>
			<tr>
				<td><h3>Name:</h3></td>
				<td><input type="text" name="name" minlength="2" maxlength="30" autofocus required/></td>
			</tr>
			<tr>
				<td><h3>Experience:</h3></td>
				<td><input type="text" name="experience" maxlength="30" autofocus required/></td>
			</tr>
			<tr>
				<td><h3>Contact Number: </h3></td>
				<td><input type="text" name="contactNumber" maxlength="10" pattern="[6-9]\d{9}" required /></td>
			</tr>
			<tr>
				<td><h3>Which grade you prefer to take: </h3></td>
				<td>
					<div class="custom-select">
						<select id="gradePreference" name="gradePreference">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</div>	
				</td>
			</tr>
			<tr>
				<td><h3>Which board you prefer to take: </h3></td>
				<td>
					<select id="boardPreference" name="boardPreference">
						<option value="ICSE">ICSE</option>
						<option value="CBSE">CBSE</option>
						<option value="State Board">State Board</option>
						<option value="ISC">ISC</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><h3>Which subject you prefer to take: </h3></td>
				<td>
					<select id="subjectPreference" name="subjectPreference">
						<option value="Computer Science">Computer Science</option>
						<option value="Physics">Physics</option>
						<option value="Chemistry">Chemistry</option>
						<option value="Biology">Biology</option>
						<option value="Geography">Geography</option>
						<option value="History">History</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><h3>Username: </h3></td>
				<td><input type="text" name="username" minlength="2" maxlength="20" required /></td>
			</tr>
			<tr>
				<td><h3>Choose a strong password: </h3></td>
				<td><input type="password" name="password" maxlength="20" required /></td>
			</tr>
			<tr style="text-align:center">
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>	
			<input type="hidden" name="availability" value="Y" required/>
		</form>
		<br />
		<a href="/instructor/login">Already an user ? Login !!</a>
	</div>
</body>
</html>
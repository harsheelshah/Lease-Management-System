<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Hashtable"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Resident</title>
</head>
<body>

	<%
		Hashtable errors = (Hashtable) this.getServletContext()
				.getAttribute("Errors");
	%>

<body>
	<table border>
		<tr>
			<td colspan=2>SignUp</td>
		</tr>
		<form action='RegisterResident' method='post'>
			<tr>
				<td>Username:</td>
				<td><input type='text' name='Username' required /></td>
			</tr>
			<tr>
				<td>EmailID:</td>
				<td><input type='text' name='EmailID' required /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='Password' required /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type='password' name='ConfirmPassword' required />
				</td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><input type='text' name='ContactNumber' required /></td>
			</tr>
			<tr>
				<td>No of People:</td>
				<td><input type='text' name='NoofPeople' required /></td>
			</tr>

			<%
				if (errors.containsKey("err")) {
					out.print("<div class = \"error\" >"
							+ errors.get("err").toString() + "</div>");
				}

				if (errors.containsKey("invalid")) {
					out.print("<div class = \"error\" >"
							+ errors.get("invalid").toString() + "</div>");
				}
			%>

			<tr>
				<td>Occupation:</td>
				<td><input type='radio' name='Occupation' value='Student' />Student
					<br />
				<input type='radio' name='Occupation' value='Family' />Family <br />
				<input type='radio' name='Occupation' value='Busniess' />Busniess</td>
			</tr>

			<tr>
				<td>Type:</td>
				<td><input type='radio' name='Type' value='1BHK' />1BHK <br />
				<input type='radio' name='Type' value='2BHK - 1 Bath' /> 2BHK - 1
					Bath<br />
				<input type='radio' name='Type' value='2BHK - 2 Bath' /> 2BHK - 2
					Bath</td>
			</tr>
			<tr>
				<td>Preferences:</td>
				<td><input type='text' name='Preferences' required /></td>
			</tr>

			<tr>
				<td>Need from Date:</td>
				<td><input type='text' name='NeedfromDate' required /></td>
			</tr>

			<tr>
				<td colspan=2><input type='submit' name='register'
					value='Register' /></td>
			</tr>

		</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Hashtable"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<%
		Hashtable errors = (Hashtable) this.getServletContext()
				.getAttribute("Errors");
	%>

	<form action='Login' method='post'>
		<table border>
			<tr>
				<td colspan=2><center>
						<b>Lease Management System</b>
					</center></td>
			</tr>
			<tr>
				<td colspan=2><center>Login</center></td>
			</tr>

			<tr>
				<td>Email ID:</td>
				<%
					if (errors.containsKey("err")) {
						out.print("<div class =  \"error\" >"
								+ errors.get("err").toString() + "</div>");
					}
					if (errors.containsKey("invalid")) {
						out.print("<div class = \"error\" >"
								+ errors.get("invalid").toString() + "</div>");
					}
				%>
				<td><input type='text' name='EmailID' required /></td>
			</tr>


			<tr>
				<td>Password:</td>
				<td><input type='password' name='Password' required /></td>
			</tr>



			<tr>
				<td><input type='submit' name='login' value='Submit' /></td>
				<td><input type='reset' name='clear' value='Clear' /></td>
			</tr>

			<tr>
				<td colspan=2><center>
						<a href='RegisterResident'> Register </a>
					</center></td>
			</tr>

			</form>

		</table>
</body>
</html>
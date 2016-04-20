<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Apartment</title>
</head>
<body>


	Add Apartment Details
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<a href='signout'> Signout </a>
	<form action='AddApartment' method='post'>
		<table border>
			<tr>
				<td>ApartmentNo:</td>
				<td><input type='text' name='ApartmentNo' /></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><input type='radio' name='Type' value='1BHK' />1BHK <br>
				<input type='radio' name='Type' value='2BHK - 1 Bath' /> 2BHK - 1
					Bath<br>
				<input type='radio' name='Type' value='2BHK - 2 Bath' /> 2BHK - 2
					Bath</td>
			</tr>
			<tr>
				<td>Facilities:</td>
				<td><textarea name='Facilities'></textarea></td>
			</tr>
			<tr>
				<td>Maximum People:</td>
				<td><input type='text' name='MaximumPeople' /></td>
			</tr>
			<tr>
				<td>Rent:</td>
				<td><input type='text' name='Rent' /></td>
			</tr>
			<tr>
				<td>Deposits:</td>
				<td><input type='text' name='Deposits' /></td>
			</tr>

			<tr>
				<td><input type='submit' name='submit' value='Submit' /> <input
					type='reset' name='clear' value='Clear' /></td>
			</tr>

		</table>
	</form>




</body>
</html>
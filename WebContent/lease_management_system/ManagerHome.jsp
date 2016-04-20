<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ManagerHome</title>
</head>
<body>

	<%
		String u1 = (String) session.getAttribute("Username");
	%>

	<b>Lease Management System</b>
	<br>
	<br> Welcome
	<%=u1%>! &nbsp&nbsp&nbsp
	<a href='signout'> Signout </a>
	<br>
	<br>
	<br>
	<a href='AddApartment'> Add Apartment </a>
	<br>
	<br>
	<a href='ViewApartment'> View Apartment </a>

</body>
</html>
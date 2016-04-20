<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="lease_management_system.ApartmentDetails"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="c" class="lab5.ViewLibraryDB" scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		HttpSession session1 = request.getSession();
		String u1 = (String) session.getAttribute("Username");
	%>

	<b>Lease Management System</b>
	<br>
	<br> Welcome
	<%=u1%>! &nbsp&nbsp&nbsp
	<a href='signout'> Signout </a>
	<br>

	<br> Rent History:
	<br>
	<br>

	<table border=1>
		<tr>
			<td>Apartment No</td>
			<td>UserName</td>
			<td>Rent</td>
			<td>Rent Paid</td>
			<td>Month</td>
			<td>Year</td>
		</tr>

		<c:forEach items="${Application}" var="ld">
			<tr>
				<td><c:out value="${ld.username}"></c:out></td>
				<td><c:out value="${ld.apartmentNo}"></c:out></td>
				<td><c:out value="${ld.rent}"></c:out></td>
				<td><c:out value="${ld.rentPaid}"></c:out></td>
				<td><c:out value="${ld.month}"></c:out></td>
				<td><c:out value="${ld.year}"></c:out></td>

			</tr>
		</c:forEach>

	</table>
</body>
</html>
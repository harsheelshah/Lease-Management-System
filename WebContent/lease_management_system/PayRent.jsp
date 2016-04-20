<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="lease_management_system.*"%>

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

	<br> Pay Rent:
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
			<td>Operation</td>
		</tr>

		<c:forEach items="${Application}" var="ld">

			<form action='PayRent' method='post'>

				<tr>
					<td><c:out value="${ld.apartmentNo}"></c:out></td>
					<td><c:out value="${ld.username}"></c:out></td>

					<td><c:out value="${ld.rent}"></c:out></td>

					<%--  <c:set value = "RentPaid_${ld.apartmentNo}" name = "RentPaid"></c:set> --%>
					<td><input type="text" name="RentPaid" value="RentPaid"></td>
					<td><select name="month">

							<option name="Jan" value="Jan">Jan</option>
							<option name="Feb" value="Feb">Feb</option>
							<option name="Mar" value="Mar">Mar</option>
							<option name="Apr" value="Apr">Apr</option>
							<option name="May" value="May">May</option>
							<option name="Jun" value="Jun">Jun</option>
							<option name="Jul" value="Jul">Jul</option>
							<option name="Aug" value="Aug">Aug</option>
							<option name="Sept" value="Sept">Sept</option>
							<option name="Oct" value="Oct">Oct</option>
							<option name="Nov" value="Nov">Nov</option>
							<option name="Dec" value="Dec">Dec</option>
					</select></td>
					<td><select name="year">

							<option name="2011" value="2011">2011</option>
							<option name="2012" value="2012">2012</option>
							<option name="2013" value="2013">2013</option>
							<option name="2014" value="2014">2014</option>
							<option name="2015" value="2015">2015</option>

					</select></td>

					<input type='hidden' value='${ ld.username }' name='username'>
					<input type='hidden' value='${ ld.apartmentNo }' name='apartmentNo'>
					<td><input type="Submit" name="Done" value="Done" /></td>

					<!-- <td><a href = 'Done' onclick="done(this)">Done</a></td>  -->

				</tr>

				<%-- <c:out value = "Rent_${ld.apartmentNo}"></c:out> --%>

			</form>
		</c:forEach>
	</table>

</body>
</html>
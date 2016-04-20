<%@page import="lease_management_system.Application"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LookUpApartment</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
</head>
<body>

	<c:if test="${empty Application}">

		<h2>No one has applied yet.</h2>
	</c:if>

	<c:if test="${not empty Application}">
		<table border=2>
			<tr>
				<td>Application No:</td>
				<td>User Name:</td>
				<td>Contact Number</td>
				<td>Apartment Number:</td>
				<td>AppointmentDate:</td>
				<td>Status:</td>
				<td>Rent Out:</td>
				<td>Ruled Out Date:</td>
			</tr>
			<c:forEach items="${ Application }" var="entries">
				<c:if test="${param.apno == entries.apartmentNo }">
					<c:forEach items="${ userdetails }" var="userdetails">
						<c:if test="${entries.username == userdetails.username }">
							<tr>
								<td>${entries.applicationNo }</td>
								<td>${entries.username}</td>
								<td>${userdetails.contactNumber}
								<td>${ entries.apartmentNo }</td>
								<td>
									<form action='ViewAvailability' method='post'>
										<input type='text' name='apdate'
											value="${entries.rescheduledDate }" /> <input type='hidden'
											value='${ entries.apartmentNo }' name='aptno'> <input
											type='hidden' value='${ entries.username }' name='username'>
										<input type='submit' value='Reschedule date' />
									</form>
								</td>
								<td>${entries.status}</td>
								<td><a
									href="RentOut?aptno=${ entries.apartmentNo }&username=${entries.username}">Rent
										Out</a></td>
								<td>${entries.ruledOutDate}</td>
						</c:if>



					</c:forEach>
				</c:if>

			</c:forEach>

			</tr>
		</table>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="lease_management_system.Application"%>
<%@page import="lease_management_system.ApartmentDetails"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LookUpApartment</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>


	<%
		String u1 = (String) session.getAttribute("Username");
	%>

	<b>Lease Management System</b>
	<br>
	<br> Welcome
	<%=u1%>
	! &nbsp;&nbsp;&nbsp;
	<a href='signout'> Signout </a>
	<br>

	<br> Look up Apartments
	<br>
	<br>
	<c:set var="uname" value="<%=u1%>" />



	<table border=1 class="table-bordered">
		<tr>
			<td>Apartment No</td>
			<td>Type</td>
			<td>Facilities</td>
			<td>MaximumPeople</td>
			<td>Rent</td>
			<td>Deposits</td>
			<td>Vacant</td>
			<td>Operations</td>
			<td>Appointment Date (By Manager)</td>
			<td>Accept/Deny</td>
			<td>Status</td>
		</tr>



		<c:forEach items="${ appdet }" var="entries">
			<%-- <c:if test="${entries.appointmentResult  ne 'Rented' }"> --%>

			<tr>
				<td>${ entries.apartmentNo }</td>
				<td>${ entries.type }</td>
				<td>${ entries.facilities }</td>
				<td>${ entries.maximumPeople }</td>
				<td>${ entries.rent }</td>
				<td>${ entries.deposits }</td>
				<td>${ entries.vacant }</td>
				<td>
					<%-- <c:forEach items="${ application }" var="entries1">	
			<c:if test="${ uname == entries1.username }"> 
			<c:if test="${entries.apartmentNo eq entries1.apartmentNo }"> 
			<c:if test="${empty entries1.applicationNo} }">
			 --%> <a
					href="RequestMapping?aptno=${ entries.apartmentNo }&username=${uname}&rent=${ entries.rent }">Request
						Appointment</a> <%-- </c:if>
			</c:if>
			 </c:if> 
			 </c:forEach> --%>



				</td>

				<td><c:forEach items="${ application }" var="entries1">
						<c:if test="${ uname == entries1.username }">
							<c:if test="${entries.apartmentNo eq entries1.apartmentNo }">
			${ entries1.rescheduledDate }
			
			</c:if>
						</c:if>
					</c:forEach></td>
				<td><c:forEach items="${ application }" var="entries1">

						<c:if test="${ uname == entries1.username }">
							<c:if test="${entries.apartmentNo eq entries1.apartmentNo }">
								<c:if test="${ not empty entries1.rescheduledDate }">
									<form action='LookUpApartment' method='post'>
										<input type="hidden" name="aptno"
											value="${ entries.apartmentNo }" /> <input type="hidden"
											name="username" value='<%=u1%>' /> <input type="submit"
											name="accept" value="Accept" /> <input type="submit"
											name="reject" value="Deny" />
									</form>

								</c:if>
							</c:if>
						</c:if>

					</c:forEach></td>
				<td><c:forEach items="${ application }" var="entries1">
						<c:if test="${ uname == entries1.username }">
							<c:if test="${entries.apartmentNo eq entries1.apartmentNo }">
								<c:if test="${ not empty entries1.rescheduledDate }">
			${ entries1.status } 
			</c:if>
							</c:if>
						</c:if>
					</c:forEach></td>
			</tr>
			<%-- </c:if> --%>
		</c:forEach>


	</table>
</body>
</html>
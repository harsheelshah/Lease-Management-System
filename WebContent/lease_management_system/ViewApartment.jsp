<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="lease_management_system.ApartmentDetails"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewApartment</title>
</head>
<body>



	<%
		List<ApartmentDetails> ad = (List<ApartmentDetails>) getServletContext()
				.getAttribute("ApartmentDetails");

		HttpSession session1 = request.getSession();
		String u1 = (String) session.getAttribute("Username");
	%>

	<b>Lease Management System</b>
	<br>
	<br> Welcome
	<%=u1%>! &nbsp&nbsp&nbsp
	<a href='signout'> Signout </a>
	<br>

	<br> Apartment Details:
	<br>
	<br>

	<table border=1>
		<tr>
			<td>Apartment No</td>
			<td>Type</td>
			<td>Facilities</td>
			<td>MaximumPeople</td>
			<td>Rent</td>
			<td>Deposits</td>
			<td>Vacant</td>
			<td>Available</td>
			<td>Appointments</td>

		</tr>
		<%
			for (ApartmentDetails uu1 : ad) {

				String apartmentno = uu1.getApartmentNo();
				String type = uu1.getType();
				String facility = uu1.getFacilities();
				String MaxPeople = uu1.getMaximumPeople();
				String rent = uu1.getRent();
				String deposits = uu1.getDeposits();
				String Vacant = uu1.getVacant();
				String Available = uu1.getAvailable();
				String Appointments = uu1.getAppointments();
				//String AppointmentDate = uu1.getAppointmentDate();
		%>
		<tr>
			<td><%=apartmentno%></td>
			<td><%=type%></td>
			<td><%=facility%></td>
			<td><%=MaxPeople%></td>
			<td><%=rent%></td>
			<td><%=deposits%></td>
			<td><%=Vacant%></td>
			<td><%=Available%></td>

			<td><a href="ViewAvailability?apno=<%=apartmentno%>">View
					Applicants </a> <%-- <%=Appointments%> --%></td>

		</tr>

		<%
			}
		%>
	</table>

	<a href="PayRent">Pay Rent </a>
	<br>
	<a href="ShowRentHistory">Show Rent History </a>
</body>
</html>
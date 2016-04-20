<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

	<br> Rent out Apartments
	<br>
	<br>
	<c:set var="uname" value="<%=u1%>" />

	<table border="2">

		<tr>
			<td>Lease Termination Date</td>
			<td>Lease Holder Name</td>
			<td>List of Documents</td>
			<td>Rent</td>
			<td>Deposits</td>
		</tr>
		<tr>
			<td><input type="text" name="LTD" value="LTD"></td>
			<td><input type="text" name="LHN" value="LHN"></td>
			<td><input type="text" name="LOD" value="LOD"></td>
			<td><input type="text" name="Rent" value="Rent"></td>
			<td><input type="text" name="Deposits" value="Deposits"></td>
		</tr>

		<tr>
			<form action='RentOut' method='post'>
				<%-- <c:forEach items="${ application }" var="entries1">	
			<c:if test="${ uname == entries1.username }"> --%>
				<input type='hidden' value='${ aptno }' name='aptno'> <input
					type='hidden' value='${ username }' name='username'>
				<td><input type='submit' name="rentout" value='Submit'></input></td>
				<td><input type='reset' name='Reset'></input></td>
				<%--  </c:if>
		  </c:forEach>  --%>
			</form>

		</tr>
	</table>

</body>
</html>
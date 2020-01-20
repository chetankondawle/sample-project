<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kondawle.model.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Employee> el = (List<Employee>) request.getAttribute("elist");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>
<body>
	<div class="jumbotron">
		<form:form method="post" action="save" modelAttribute="employee">
			<table>
				<tr>
					<td>First Name :</td>
					<td><form:input type="text" path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><form:input type="text" path="lastName" /></td>
				</tr>
				<tr>
					<td>Age :</td>
					<td><form:input type="text" path="age" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"
						class="btn btn-large" /></td>
				</tr>
			</table>
		</form:form>


	</div>
	<div class="jumbotron">
		<h2>${message}</h2>
		<table class="table " style="margin: 10px">
			<tr>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<%
				if (el != null) {
					for (Employee e : el) {
			%>
			<tr id="emp<%=e.getId()%>">
				<td id="name<%=e.getId()%>"><%=e.getFirstName()%> <%=e.getLastName()%></td>
				<td id="age<%=e.getId()%>"><%=e.getAge()%></td>
				<td><input type="button"
					onclick="editFunction(<%=e.getId()%>)" value="Edit"
					class="btn btn-success"></td>
				<td><a href="delete/<%=e.getId()%>"
					class="btn btn-danger">Delete</a></td>
			<tr>
				<%
					}
					}
				%>
			
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1><c:out value="${dojo.name} Location Ninjas"></c:out></h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneNinja" items="${dojo.ninjas}">
				<tr>
					<td><c:out value="${oneNinja.firstName}"></c:out></td>
					<td><c:out value="${oneNinja.lastName}"></c:out></td>
					<td><c:out value="${oneNinja.age}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
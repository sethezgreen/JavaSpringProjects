<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Expense</title>
</head>
<body>
	<div class="top-nav">
		<h1>Expense Details</h1>
		<a href="/expenses">Go back</a>
	</div>
	<table>
		<tr>
			<td>Expense name</td>
			<td><c:out value="${expense.expenseName}"></c:out></td>
		</tr>
		<tr>
			<td>Expense Description</td>
			<td><c:out value="${expense.description}"></c:out></td>
		</tr>
		<tr>
			<td>Vendor</td>
			<td><c:out value="${expense.vendor}"></c:out></td>
		</tr>
		<tr>
			<td>Amount</td>
			<td><c:out value="$ ${expense.amount}"></c:out></td>
		</tr>
	</table>
</body>
</html>
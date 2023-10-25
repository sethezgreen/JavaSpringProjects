<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Save Travels</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Save Travels</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneExpense" items="${expenses}">
				<tr>
					<td><a href="/expenses/${oneExpense.id}"><c:out value="${oneExpense.expenseName}"></c:out></a></td>
					<td><c:out value="${oneExpense.vendor}"></c:out></td>
					<td><c:out value="$ ${oneExpense.amount}"></c:out></td>
					<td>
						<a href="/expenses/edit/<c:out value="${oneExpense.id}"></c:out>">edit</a>
						<form action="/expenses/${oneExpense.id}" method="post">
						<input type="hidden" name="_method" value="delete" />
						<input type="submit" value="Delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2>Add an Expense:</h2>
<div class="form">
	<form:form action="/expenses" method="post" modelAttribute="expense">
		<p>
			<form:label path="expenseName">Expense Name</form:label>
			<form:errors path="expenseName"/>
			<form:input path="expenseName"/>
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor"/>
			<form:input path="vendor"/>
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount"/>
			<form:input type="number" path="amount"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>
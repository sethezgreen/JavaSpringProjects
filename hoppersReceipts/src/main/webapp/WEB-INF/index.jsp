<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Receipt</title>
</head>
<body>

	<h1>Customer Name: <c:out value="${name}"></c:out></h1>
	<p>Item Name: <c:out value="${itemName}"></c:out></p>
	<p>Price: $<c:out value="${price}"></c:out></p>
	<p>Description: <c:out value="${description}"></c:out></p>
	<p>Vendor: <c:out value="${vendor}"></c:out></p>
</body>
</html>
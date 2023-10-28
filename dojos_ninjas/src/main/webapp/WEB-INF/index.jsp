<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
</head>
<body>
	<h1>Create Links</h1>
	<a href="/dojos/new">Create Dojo</a>
	<a href="/ninjas/new">Create Ninja</a>
	<h1>Dojos</h1>
	<ul>
		<c:forEach var="oneDojo" items="${dojos}">
			<li><a href="/dojos/${oneDojo.id}"><c:out value="${oneDojo.name}"></c:out></a></li>
		</c:forEach>
	</ul>
</body>
</html>
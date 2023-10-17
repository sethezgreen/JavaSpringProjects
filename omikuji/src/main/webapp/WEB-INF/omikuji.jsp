<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Omikuji</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Here's Your Omikuji!</h1>
		<div class="omikuji blue-background">
			<p><c:out value="In ${num} years, you will live in ${city} with ${person} as your roommate, ${hobby}. The next time you see a ${livingThing}, you will have good luck. Also, ${message}"></c:out></p>
		</div>
		<a href="/omikuji">Go Back</a>
	</div>
</body>
</html>
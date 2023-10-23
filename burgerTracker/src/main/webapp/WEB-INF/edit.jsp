<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>    
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Burger Tracker</title>
</head>
<body>
<div class="top-nav">
<h1>Edit Burger</h1>
<a href="/burgers">Go Back</a>
</div>
<form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
    <input type="hidden" name="_method" value="put">
    <div>
        <form:label path="burgerName">Burger Name</form:label>
        <form:errors path="burgerName"/>
        <form:input path="burgerName"/>
    </div>
    <div>
        <form:label path="restaurantName">Restaurant Name</form:label>
        <form:errors path="restaurantName"/>
        <form:input path="restaurantName"/>
    </div>
    <div>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating"/>
    </div>
    <div>
        <form:label path="notes">Notes</form:label>
        <form:errors path="notes"/>     
        <form:input path="notes"/>
    </div>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
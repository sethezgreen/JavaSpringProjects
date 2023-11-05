<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="top-nav">
   		<h1>Add a Book to Your Shelf!</h1>
		<a href="/books">back to the shelves</a>
	</div>
	<form:form action="/books/new" method="post" modelAttribute="book" class="form">
		
		<form:label path="title">Title:</form:label>
		<form:input path="title"/>
		<form:errors path="title"/>
		
		<form:label path="author">Author:</form:label>
		<form:input path="author"/>
		<form:errors path="author"/>
		
		<form:label path="thoughts">My Thoughts:</form:label>
		<form:textarea path="thoughts"/>
		<form:errors path="thoughts"/>
		
		<input type="submit" value="create"/>
	</form:form>
</body>
</html>


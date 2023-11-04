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
   <h1><i><c:out value="${book.title}"></c:out></i></h1>
	<a href="/books">back to shelves</a>
</div>
<p><c:out value="${book.user.name} read ${book.title} by ${book.author}."></c:out></p>
<p><c:out value="Here are ${book.user.name}'s thoughts:"></c:out></p>
<p><c:out value="${book.thoughts}"></c:out></p>
<c:if test = "${book.user.id == userId }">
	<form action="/books/edit/${book.id}" method="post">
		<input type="submit" value="edit" />
	</form>
</c:if>
</body>
</html>


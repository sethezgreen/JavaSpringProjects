<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reading Books</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>   
<h1>All Books</h1>
<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="oneBook" items="${books}">
         	<tr>
         		<td><c:out value="${oneBook.id}"></c:out></td>
         		<td><a href="/books/<c:out value="${oneBook.id}"></c:out>"><c:out value="${oneBook.title}"></c:out></a></td>
         		<td><c:out value="${oneBook.language}"></c:out></td>
         		<td><c:out value="${oneBook.numberOfPages}"></c:out></td>
         	</tr>
         </c:forEach>
    </tbody>
</table>
</body>
</html>
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
<div class="container">
	<div class="top-nav">
	   <h1>Welcome, <c:out value="${loggedUser.name}"/></h1>
	   <form action="/logout" method="post">
	   		<input type="submit" value="logout" />
	   </form>	
	</div>
	<div class="top-nav">
		<p>Book's from everyone's shelves:</p>
		<div>
			<a href="/books/new" class="display-block">Add a book to my shelf!</a>
			<a href="/books/market" class="display-block">Book Lender Dashboard</a>
		</div>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBook" items="${books}">
				<tr>
					<td><c:out value="${oneBook.id}"></c:out></td>
					<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title}"></c:out></a></td>
					<td><c:out value="${oneBook.author}"></c:out></td>
					<td><c:out value="${oneBook.user.name}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>


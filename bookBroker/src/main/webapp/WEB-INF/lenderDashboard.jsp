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
    <title>Book Lender Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="container">
	<div class="top-nav">
	   <p><c:out value="Hello, ${loggedUser.name}. Welcome to.."/></p>
	   <a href="/books">back to the shelves</a>
	</div>
	   <h1>The Book Broker!</h1>
	<div class="top-nav">
		<p>Available Books to Borrow</p>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBook" items="${books}">
				<tr>
					<td><c:out value="${oneBook.id}"></c:out></td>
					<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title}"></c:out></a></td>
					<td><c:out value="${oneBook.author}"></c:out></td>
					<td><c:out value="${oneBook.user.name}"></c:out></td>
					<td>
						<c:if test = "${book.user.id == userId }">
							<form action="/books/edit/${book.id}" method="post">
								<input type="submit" value="edit" />
							</form>
							<form action="/books/${book.id}" method="post">
								<input type="hidden" name="_method" value="delete" />
								<input type="submit" value="delete" />
							</form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Books I'm Borrowing..</p>
</div>
</body>
</html>


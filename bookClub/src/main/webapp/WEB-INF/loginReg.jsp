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
	   <h1>Welcome!</h1>
	   <div class="main-content">
	   		<div>
			   <h2>Register</h2>
			   <form:form action="/register" method="post" modelAttribute="registerUser" class="form">
			   		
			   		<form:label path="name">Name:</form:label>
			   		<div class="errors">
				   		<form:input path="name"/>
				   		<form:errors path="name"/>
			   		</div>
			   		
			   		<form:label path="email">Email:</form:label>
					<div class="errors">
				   		<form:input  path="email" type="email"/>
				   		<form:errors path="email"/>					
					</div>
			   		
			   		<form:label path="password">Password:</form:label>
				   	<div class="errors">
				   		<form:password path="password"/>
				   		<form:errors path="password"/>				   	
				   	</div>
			   		
			   		<form:label path="confirmedPassword">Confirm Password:</form:label>
			   		<div class="errors">
				   		<form:password path="confirmedPassword"/>
				   		<form:errors path="confirmedPassword"/>			   		
			   		</div>
			   		
			   		<input type="submit" value="Register"/>
			   </form:form>
	   		</div>
		   <div>
			   <h2>Login</h2>
			   <form:form action="/login" method="post" modelAttribute="loginUser" class="form">
			   		
			   		<form:label path="email">Email:</form:label>
			   		<div class="errors">
				   		<form:input  path="email" type="email"/>
				   		<form:errors path="email"/>			   		
			   		</div>
			   		
			   		<form:label path="password">Password:</form:label>
			   		<div class="errors">
				   		<form:password path="password"/>
				   		<form:errors path="password"/>			   		
			   		</div>
			   		
			   		<input type="submit" value="Login" />
			   </form:form>
		   </div>
	   </div>
	</div>
</body>
</html>


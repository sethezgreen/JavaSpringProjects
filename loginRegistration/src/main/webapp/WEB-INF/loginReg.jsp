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
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
   <h1>Welcome!</h1>
   <h2>Register</h2>
   <form:form action="/register" method="post" modelAttribute="registerUser">
   		
   		<form:label path="userName">User Name</form:label>
   		<form:errors path="userName"/>
   		<form:input path="userName"/>
   		
   		<form:label path="email">Email</form:label>
   		<form:errors path="email"/>
   		<form:input  path="email" type="email"/>
   		
   		<form:label path="password">Password</form:label>
   		<form:errors path="password"/>
   		<form:password path="password"/>
   		
   		<form:label path="confirmedPassword">Confirm Password</form:label>
   		<form:errors path="confirmedPassword"/>
   		<form:password path="confirmedPassword"/>
   		
   		<input type="submit" value="Register"/>
   </form:form>
   
   <h2>Login</h2>
   <form:form action="/login" method="post" modelAttribute="loginUser">
   		
   		<form:label path="email">Email</form:label>
   		<form:errors path="email"/>
   		<form:input  path="email" type="email"/>
   		
   		<form:label path="password">Password</form:label>
   		<form:errors path="password"/>
   		<form:password path="password"/>
   		
   		<input type="submit" value="Login" />
   </form:form>
</body>
</html>


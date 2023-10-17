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
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/form" method="post">
		<label>
			Pick any number from 5 to 25
			<input type="number" name="num"/>
		</label>
		<label>
			Enter the name of any city.
			<input type="text" name="city"/>
		</label>
		<label >
			Enter the name of any real person
			<input type="text" name="person"/>
		</label>
		<label>
			Enter professional endeavor or hobby:
			<input type="text" name="hobby"/>
			</label>
		<label>
			Enter any type of living thing.
			<input type="text" name="livingThing"/>
		</label>
		<label>
			Say something nice to someone:
			<textarea name="message" cols="30" rows="10"></textarea>
		</label>
		<p>Send and show a friend</p>
		<input type="submit" value="Send" />
	</form>
</body>
</html>
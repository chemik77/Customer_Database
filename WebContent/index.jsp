<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%
	Date date = new Date();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Customers database</title>
</head>
<body>
<div id="container">
<div id="header">
	<h1>Customers database</h1>
	</div>
	<p>
		Hello today's date is <%=date%>
		<br /> <br /> 
		<a href="read" class="button">Customers</a>
	</p>
	</div>
</body>
</html>
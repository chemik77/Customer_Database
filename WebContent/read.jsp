<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String table = (String) request.getAttribute("table");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Customers Database</title>
</head>
<body>
<div id="container">
<div id="header">
	<h1>Customers Database</h1></div>
	<a href="add" class="button">Add a customer</a>
	<br />
	<br />
	<%=table%>


</div>
</body>
</html>
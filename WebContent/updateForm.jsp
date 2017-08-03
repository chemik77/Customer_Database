<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pl.chemik77.model.Customer" %>
<%@ page import="pl.chemik77.model.Address" %>
<%
	Customer customer = (Customer) request.getAttribute("customer");
	Address address = (Address) request.getAttribute("address");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Customers Database - Update a customer</title>
</head>
<body>
<div id="container">
<div id="header">
	<h1>Customers Database - Update a customer</h1></div>
	<br />
	<a href="read" class="button">Back</a>
	<br />
	<div>
	<form name=updateForm action=updateCustomer method=get>
		<label>Customer:</label>
		<input type=hidden name=customer_id value="<%= customer.getCustomer_id() %>" /> <br />
		<label>Last name:</label>
		<input type=text name=lastName value="<%= customer.getLastName() %>" /> <br />
		<label>First name:</label>
		<input type=text name=firstName value="<%= customer.getFirstName() %>" /> <br />
		<label>Email:</label>
		<input type=text name=email value="<%= customer.getEmail() %>" /> <br /> <br />
		
		<label>Address:</label> <br />
		<input type=hidden name=address_id value="<%=address.getAddress_id() %>" />
		<label>Street:</label>
		<input type=text name=street value="<%= address.getStreet()  %>" />
		<label>House no.:</label>
		<input type=text name=houseNo value="<%= address.getHouseNo() %>" /> <br />
		<label>Postal code:</label>
		<input type=text name=postalCode value="<%= address.getPostalCode() %>" />
		<label>City:</label>
		<input type=text name=city value="<%= address.getCity() %>" /> <br />
		<label>Country:</label>
		<input type=text name=country value="<%= address.getCountry() %>" /> <br /> <br/>
		
		<label>Store in:</label>
		<input type=text name=store_id value="<%= customer.getStore_id() %>" /> <br />
		<label>Active:</label>
		<input type=text name=active value="<%= customer.getActive() %>" /> <br />
		<input type=submit name=submit value="Update the customer" />
		<input type="reset" name="clear" value="Clear" />
	</form></div></div>
</body>
</html>
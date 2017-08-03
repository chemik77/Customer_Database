<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Customers Database - Add a customer</title>
</head>
<body>
<div id="container">
<div id="header">
	<h1>Customers Database - Add a customer</h1></div>
	<br />
	<a href="read" class="button">Back</a>
	<br />
	<form name=addForm action=addCustomer method=get>
		<label>Last name:</label>
		<input type=text name=lastName value="" /> <br />
		<label>First name:</label>
		<input type=text name=firstName value="" /> <br />
		<label>Email:</label>
		<input type=text name=email value="" /> <br /><br/>
		
		<label>Address:</label><br/>
		<label>Street:</label>
		<input type=text name=street value="" />
		<label>House no.:</label>
		<input type=text name=houseNo value="" /> <br />
		<label>Postal code:</label>
		<input type=text name=postalCode value="" />
		<label>City:</label>
		<input type=text name=city value="" /> <br />
		<label>Country:</label>
		<input type=text name=country value="" /> <br /><br/>
		
		<label>Store in:</label>
		<select name=store_id>
		<option value=1>Warszawa</option>
		<option value=2>Wroclaw</option>
		</select> <br />
		<label>Active:</label>
		<select name=active>
		<option value=1>YES</option>
		<option value=0>NO</option>
		</select> <br />
		<input type=submit name=submit value="Add a customer" />
		<input type="reset" name="clear" value="Clear" />
	</form></div>
</body>
</html>
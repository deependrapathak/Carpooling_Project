<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<div class="randompad">
<div id="formcenter">
<div class="formholderr">
<h1 id="h1reg">Please Register</h1>
<form action="UserServlet" method="post" id="formreg">

<label>Full Name:</label><input type="text" name="txtFullName"><br>
<label>Gender: </label><input type="radio" name="rdGender" value="Male">Male
<input type="radio" name="rdGender" value="Female">Female<br>
<label>State: </label> <input type="text" name="txtState"><br>
<label>City: </label><input type="text" name="txtCity"><br>
<label>Street: </label><input type="text" name="txtStreet"><br>
<label>Zip Code: </label><input type="text" name="txtZipCode" pattern="[\d]{5}" title="five digit number only"><br>
<label>Birth Year: </label><input type="text" name="txtBirthYear" pattern="[\d]{4}" title="Invalid year four digit number"><br>
<label>Email: </label><input type="email" name="txtEmail"><br>
<label>Password: </label><input type="password" name="txtPassword" pattern="(?=\d+)(?=[a-z]+)(?=[A-Z]+).{6,}" title="Password should be minimum 6 char and one number one capital and one small letter required"><br>
<input type="submit" value="Register">

</form>
</div>
</div>
</div>
</body>
</html>
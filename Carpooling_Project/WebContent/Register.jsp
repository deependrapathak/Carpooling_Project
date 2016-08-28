<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Please Register</h1>
<form action="UserServlet" method="post">
Full Name:<input type="text" name="txtFullName"><br>
Gender:<input type="radio" name="rdGender" value="Male">Male
<input type="radio" name="rdGender" value="Female">Female<br>
State: <input type="text" name="txtState"><br>
City: <input type="text" name="txtCity"><br>
Street: <input type="text" name="txtStreet"><br>
Zip Code: <input type="text" name="txtZipCode"><br>
Birth Year: <input type="text" name="txtBirthYear"><br>
Email: <input type="text" name="txtEmail"><br>
Password:<input type="password" name="txtPassword"><br>
<input type="submit" value="Register">
</form>
</body>
</html>
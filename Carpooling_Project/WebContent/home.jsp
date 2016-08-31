<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/CustomTag/customtag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="js/load.js"></script>
<link rel="stylesheet" href="css/home.css">

</head>
<body>
<%-- <%ArrayList<String> ar=(ArrayList<String>)request.getAttribute("data"); %> --%>
<div id="postcontainer">

<div id="postmenu">
 <c:custom textColor='yellow' text='CARPOOLING'/> <br>
 <ul id="ulmenu">
 <li>Ask Ride</li>
 <li>Offer ride</li>
 <li>Update Profile</li>
 <li>Weather</li>
 <li>Delete Post</li>
 
 
 </ul>
</div>
<div id="postdiv">
<textarea rows="8" cols="80" ></textarea><br><br>
<label>Type :</label><input type="radio" name="rdType"> Offer Ride  <input type="radio" name="rdType">Take Ride<br><br>
<input type="submit" value="    post   ">

</div>
</div>
<div id="ajdiv">
<%-- <%for(int i=0;i<ar.size()-1;i++){
	out.println("<div class='post'><p>"+ar.get(i)+"</p>"+
"<a href='#' class='posta'>  Like   </a><a href='#' class='posta'>  Comment   </a></div>");
} %> --%>
<%-- <%=request.getAttribute("msg") %>--%>
</div>
</body>
</html>
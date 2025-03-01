<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><a href='./home'> Home </a>|<a href='cntus.jsp'> Contact us </a>|<a href='abtus.jsp'> About us </a>|<a href='help.jsp'> Help </a></center>
<br><br><br>
<form action="userpage.jsp" method="post">
username <input type="text" size="20" name="uname"><br><br>
password <input type="text" size="20" name="upwd"><br><br>
<input type="submit" value="login">
</form>
<p style="color: red;">${msg}</p> 
<br><br>
</body>
</html>
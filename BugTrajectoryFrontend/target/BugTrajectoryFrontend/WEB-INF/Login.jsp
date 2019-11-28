<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div align="center">
<form action="Signin" method="post">
<table>
	<tr>
		<td>login Id:</td>
		<td><input type="email" name="email" onblur="this.value=removeSpaces(this.value)" required></td>
	</tr>
	<tr>
		<td>Password :</td>
		<td><input type="password" name="password" required> </td>
	</tr>
	<tr>
	<td></td>
	<td colspan="2"><input type="submit" value="Login" required></td>
	</tr>
</table>
</form>
</div>
</body>
</html>
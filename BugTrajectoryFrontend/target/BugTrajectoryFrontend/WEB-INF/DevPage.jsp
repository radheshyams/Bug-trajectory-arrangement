<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Developer page</title>
</head>
<body>
<div align="center">
		<h1>Welcome ${uObj.role}:- ${uObj.user_Name}   having email:- ${uObj.loginId}</h1>
		<form action="">
		<table>
		<tr>
		<td>Developer Name:-</td>
		<td><input type="text" value="${uObj.user_Name}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Select Project:-</td>
			<td><select name="project">
				<option value="0">----Select Project----</option>
				<c:forEach items="${devList}" var="devValues">
  					<option value="${devValues.pId}">
  					${devValues.pName}
  					</option>
  				</c:forEach>
				</select>
			</td>

		</tr>
		
			
		<tr>
		<td></td>
		<td colspan="2"><a href="UpdateBugStatus">see Bug</a></td>
		</tr>
	</table>
	</form>
</div>

</body>
</html>
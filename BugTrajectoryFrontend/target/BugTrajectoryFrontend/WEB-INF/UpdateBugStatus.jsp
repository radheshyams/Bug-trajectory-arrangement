<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Bug Status</title>
</head>
<body>
	<div align="center" >
	<form>
	<table>
		<tr>
		<td>Project Name:-</td>
		<td><input type="text"></td>
		</tr>
		<tr>
				<td>Bug Status:-</td>
				<td>
					<select name="BugStatus">
						<option value="0">----Select BugStatus----</option>
							<c:forEach items="${bgstusList}" var="bgStatusValue">
  						<option value="${bgStatusValue.id}">
  							${bgStatusValue.name}
  						</option>
  							</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Severity:-</td>
				<td><></td>
			</tr>
			<tr>
				<td>Bug Type:-</td>
				<td><></td>
			</tr>
			<tr>
				<td>Description:-</td>
				<td><></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Fix"></td>
			</tr>
	</table>
	</form>
	</div>

</body>
</html>
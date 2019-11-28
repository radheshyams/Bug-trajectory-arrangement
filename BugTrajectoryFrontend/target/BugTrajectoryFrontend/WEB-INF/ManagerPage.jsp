<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager page</title>
<script language="javascript" type="text/javascript">

function removeSpaces(string) {
 return string.split(' ').join('');
}
</script>

</head>
<body>
<div align="center">
		<h1>Welcome ${uObj.role}:- ${uObj.user_Name}</h1>

<form action="Manager" method="post">
	<table>
		<tr>
			<td>Select Project:-</td>
			<td><select name="project">
				<option value="0">----Select Project----</option>
				<c:forEach items="${proList}" var="proValues">
  					<option value="${proValues.pId}">
  					${proValues.pName}
  					</option>
  				</c:forEach>
				</select>
			</td>

		</tr>
			
		<tr>
			<td>Select Developer:-</td>
			<td><select name="Developer" multiple="multiple">
			<option value="0">----Select Developer----</option>
				<c:forEach items="${devList}" var="devValues">
  					<option value="${devValues.user_Id}">
  					${devValues.user_Name}
  					</option>
  				</c:forEach>
				</select>
			</td>

		</tr>
		
		<tr>
			<td>Select Tester:-</td>
			<td><select name="Tester" multiple="multiple">
			<option value="0">----Select Tester----</option>
				<c:forEach items="${tstList}" var="tstValues">
  					<option value="${tstValues.user_Id}">
  					${tstValues.user_Name}
  					</option>
  				</c:forEach>
				</select>
			</td>

		</tr>
		<tr>
		<td></td>
		<td colspan="2"><input type="submit" value="Allocate"></td>
		</tr>
	</table>
</form>

</div>

</body>
</html>
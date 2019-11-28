<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <jsp:include page="DeveloperHeader.jsp"></jsp:include>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Developer page</title>
<style type="text/css">
#d2{
	background-color: rgb(255, 26, 102);
	height: 70px;
	color:rgb(0, 89, 179);
	}
</style>
</head>
<body>
<div align="center" id="d2">
		<h1>List Of Assigned Project</h1>
</div>
<hr>
<div align="center" class="container">
		<form action="${pageContext.request.contextPath}/assignBug">
		<table>
		<tr class="table-primary">
		<td class="form-control">Developer Name:-</td>
		<td><input type="text" class="form-control" size="40" value="${uObj.user_Name}" readonly="readonly"></td>
		</tr>
		<tr><td><br></td></tr>
		<tr class="table-primary">
			<td class="form-control">Select Project:-</td>
			<td><select name="project" class="form-control">
				<option value="0">----Select Project----</option>
				<c:forEach items="${devList}" var="devValues">
  					<option value="${devValues.pId}">
  					${devValues.pName}
  					</option>
  				</c:forEach>
				</select>
			</td>

		</tr>
		<tr><td><br></td></tr>
		
			
		<tr>
		<td></td>
		<td colspan="2"><a class="btn btn-info" role="button" href="assignBug">See Assigned Bug</a></td>
		</tr>
	</table>
	</form>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <jsp:include page="TesterHeader.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Allocation Form</title>
<style type="text/css">
#d2{
background-color: rgb(255, 26, 102);
height: 70px;
color:rgb(0, 89, 179);
}
</style>
</head>
<body>
<div id="d2" align="center">
<h1>Allocate Bug for project ${prObj.pName}</h1>
<h1 align="center">${msg}</h1>
</div>
<hr>
<div align="center">

<form action="${pageContext.request.contextPath}/bugAllocate" method="get">
		
		
		<table>
		<tr class="table-primary">
			<td class="form-control">Name of Tester</td>
			<td><input type="text" size="40" class="form-control" value="${uObj.user_Name}" readonly="readonly"></td>
		</tr>
		<tr><td><br></td></tr>
		
		<tr class="table-primary">
			<td class="form-control">Name of Project</td>
			<td><input type="text" size="40" class="form-control" value="${projectObj.pName}" readonly="readonly"></td>
		</tr>
		<tr><td><br></td></tr>
		<tr class="table-primary">
			<td class="form-control">Select Severity:-</td>
			<td><select name="severity" class="form-control" required>
				<option value="0">----Select Severity----</option>
				<c:forEach items="${seList}" var="seValue">
  					<option value="${seValue.sevId}">
  					${seValue.sevType}
  					</option>
  				</c:forEach>
				</select>
			</td>
			</tr>
			<tr><td><br></td></tr>
			<tr class="table-primary">
				<td class="form-control">Select BugType:-</td>
				<td>
					<select name="bugType" class="form-control" required>
						<option value="0">----Select BugType----</option>
							<c:forEach items="${bgList}" var="bgValue">
  						<option value="${bgValue.bugTypeId}">
  							${bgValue.bugTypeName}
  						</option>
  							</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td><br></td></tr>
			<tr class="table-primary">
				<td class="form-control">Description of bug:-</td>
				<td><textarea class="form-control" cols="25" rows="10" size="40" name="desc" required></textarea></td>
			</tr>
			<tr><td><br></td></tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Allocate Bug"></td>
			</tr>
</table>
</form>
</div>

</body>
</html>
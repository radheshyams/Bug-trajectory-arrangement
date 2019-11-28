<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Allocation Form</title>
</head>
<body>
${msg}
<div align="center">

<form action="${path}bugAllocate" method="get">
		<h1>Allocate Bug for project ${prObj.pName}</h1>
		
		<table>
		<tr>
			<td>Name of Tester</td>
			<td><input type="text" value="${uObj.user_Name}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Name of Project</td>
			<td><input type="text" value="${projectObj.pName}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Select Severity:-</td>
			<td><select name="Severity">
				<option value="0">----Select Severity----</option>
				<c:forEach items="${seList}" var="seValue">
  					<option value="${seValue.sevId}">
  					${seValue.sevType}
  					</option>
  				</c:forEach>
				</select>
			</td>
			</tr>
		
			<tr>
				<td>Select BugType:-</td>
				<td>
					<select name="BugType">
						<option value="0">----Select BugType----</option>
							<c:forEach items="${bgList}" var="bgValue">
  						<option value="${bgValue.bugTypeId}">
  							${bgValue.bugTypeName}
  						</option>
  							</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Description of bug:-</td>
				<td><textarea cols="25" rows="10" name="description"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Allocate Bug"></td>
			</tr>
</table>
</form>
</div>

</body>
</html>
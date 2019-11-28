<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="DeveloperHeader.jsp"></jsp:include>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Bug Status</title>
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
	<h1>Fixing Reported Bug</h1>
	</div><hr>
	
	<div align="center" class="container">
	<form action="${pageContext.request.contextPath}/fixbug" method="get">
	<table>
		<tr class="table-primary">
		<td class="form-control">Project Name:-</td>
		<td><input class="form-control" type="hidden" size="40" value="${bgDetail.bugAllocateId}" readonly="readonly" name="bugAllocateId">
		<input class="form-control" type="hidden" size="40" class="form-control" value="${bgDetail.projectObj.pId}" readonly="readonly" name="projectId">${bgDetail.projectObj.pName}
		</td>
		</tr>
		<tr><td><br></td></tr>
		<tr class="table-primary">
				<td class="form-control">Bug Status:-</td>
				<td>
				<select name="status" class="form-control">
						<option value="0">----Select BugStatus----</option>
							<c:forEach items="${bgstusList}" var="bgStatusValue">
  						<option value="${bgStatusValue.id}">
  							${bgStatusValue.name}
  						</option>
  							</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td><br></td></tr>
			<tr class="table-primary">
				<td class="form-control">Severity:-</td>
				<td><input type="text" class="form-control" value="${bgDetail.severityObj.sevType}"></td>
			</tr>
			<tr><td><br></td></tr>
			<tr class="table-primary">
				<td class="form-control">Bug Type:-</td>
				<td><input type="text" size="40" class="form-control" value="${bgDetail.bugTypeObj.bugTypeName}"></td>
			</tr>
			<tr><td><br></td></tr>
			<tr class="table-primary">
			<td class="form-control">Actual StartDate</td>
			<td><input type="Date" name="actualStartDate" required > <td>
		</tr>
		
		<tr><td><br></td></tr>
		<tr class="table-primary">
			<td class="form-control">Actual End Date</td>
			<td><input type="Date" name="actualEndDate" required ><td>
		</tr>
		<tr><td><br></td></tr>
			<tr class="table-primary">
				<td class="form-control">Description:-</td>
				<td><textarea size="40" cols="25" rows="10" class="form-control">${bgDetail.desc}</textarea></td>
			</tr>
			<tr><td><br></td></tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Fix" class="btn btn-info" role="button"></td>
			</tr>
	</table>
	</form>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="ManagerHeader.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <meta charset="utf-8">
       <meta name="viewport" content="width=device-width, initial-scale=1">
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Assign Bug To Developer</title>
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
<h1>Assign Bug To Developer</h1>
</div>
<div align="center" class="container">
	<form action="${pageContext.request.contextPath}/assigned" method="get">
		<table>
		<tr class="table-primary">
		<td class="form-control">Project Name</td>
		<td><input class="form-control" type="hidden" size="40" value="${bugDetailsObject.bugAllocateId}" readonly="readonly" name="bugAllocateId">
		<input class="form-control" type="hidden" size="40" value="${bugDetailsObject.projectObj.pId}" readonly="readonly" name="projectId">${bugDetailsObject.projectObj.pName}</td>
		</tr>
		<br><tr><td><br></td></tr>
		<tr class="table-primary">
		<td class="form-control">Bug Name</td>
		<td><input class="form-control" type="text" size="40" value="${bugDetailsObject.bugTypeObj.bugTypeName}" readonly="readonly" name=""></td>
		</tr>
		<tr><td><br></td></tr>
		<tr class="table-primary">
		<td class="form-control">Bug Severity</td>
		<td><input class="form-control" type="text"  size="40" value="${bugDetailsObject.severityObj.sevType}" readonly="readonly" name=""></td>
		</tr>
		<tr><td><br></td></tr>
		<tr class="table-primary">
		<td class="form-control">Current Bug Status</td>
		<td><input class="form-control" type="text" size="40" value="${bugDetailsObject.bugStatusObj.name}" readonly="readonly" name=""></td>
		</tr>
		<tr><td><br></td></tr>
		<tr class="table-primary">
		<td class="form-control">New Bug Status</td>
		<td><select   name="statusId" class="form-control">
    <option value="0">----Select----</option>
   		<c:forEach items="${bugStatusList}" var="bgObj">
       <option  value="${bgObj.id}">${bgObj.name}</option>
           </c:forEach>    
     </select> 
    	</td>
    	</tr>
    	<tr><td><br></td></tr>
    	<tr class="table-primary">
    	<td class="form-control">Select Developer</td>
		<td><select name="userId" class="form-control" required>
    <option value="0">----Select----</option>
   		<c:forEach items="${devList}" var="dList">
       <option value="${dList.user_Id}">${dList.user_Name}</option>
           </c:forEach>    
     </select> 
    	</td>
    	</tr>
    	<tr><td><br></td></tr>
    	<tr class="table-primary">
			<td class="form-control">Planned Assigned Date</td>
			<td><input type="Date" name="plannedStartdate" required > <td>
		</tr>
		
		<tr><td><br></td></tr>
		<tr class="table-primary">
			<td class="form-control">Planned End Date</td>
			<td><input type="Date" name="plannedEndDate" required ><td>
		</tr>
		<tr><td><br></td></tr>
		<tr class="table-primary">
			<td class="form-control">Description</td>
			<td><textarea size="40" class="form-control" cols="35.5" rows="10"  readonly="readonly">${bugDetailsObject.desc}</textarea></td>
		</tr>
		<tr><td><br></td></tr>
		<tr>
			<td> </td>
			<td colspan="2"><input type="submit" value="Assign" class="btn btn-info" role="button"></td>
		</tr>
		</table>
	</form>

</div>
</body>
</html>
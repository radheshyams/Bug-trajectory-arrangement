<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="ManagerHeader.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Bug</title>
<style>
#d1{
background-color: black;
}
#d2{
background-color: rgb(255, 26, 102);
height: 70px;
}
td {
  height: 60px;
  width:200px;
  vertical-align:middle;
  color: rgb(15, 151, 219);
  font-weight: bold;
  font-size: 25;
}
th {
  height: 60px;
  width:200px;
  vertical-align: middle;
  color: rgb(15, 151, 219);
}
#d3{
height: 400px;
background-color: black;
}

</style>
</head>
<body>
<div id="d2">
<h1 style="text-align: center;color:rgb(0, 89, 179);margin-top: 5px;padding-top: 15px;">Bugs Reported</h1>
</div>

<form action="ViewReportedBug"method="get">
<div  align="center" id="d1">
<table border="2">
<tr>
<th>Bug Allocated Id</th>
<th>Project name</th>
<th>Bug Type</th>
<th>Bug Status</th>
<th>Bug Severity</th>
<th>Bug Description</th>
<th>Allocate Bug </th>
</tr>
<c:forEach var="l" items="${bugDetailList}">
<tr>
<td>${l.bugAllocateId}</td>
<td>${l.projectObj.pName }
<td>${l.bugTypeObj.bugTypeName}</td>
<td>${l.bugStatusObj.name}</td>
<td>${l.severityObj.sevType}</td>
<td>${l.desc}</td>
<td>
<a href="${pageContext.request.contextPath}/assignBug/${l.bugAllocateId}" class="btn btn-info" role="button">Allocate Bug</a></td>
</tr>
</c:forEach>
</table>
</div>
<div id="d3">
</div>
</form>


</body>
</html>
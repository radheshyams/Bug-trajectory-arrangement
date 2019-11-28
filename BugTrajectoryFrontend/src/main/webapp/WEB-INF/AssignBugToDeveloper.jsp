<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<jsp:include page="TesterHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Allocated  Bug</title>
<style>
#d1{
background-color: black;
}
#d2{
background-color: rgb(255, 26, 102);
height: 70px;
color: rgb(0, 89, 179);
}
td {
  height: 80px;
  width:180px;
  vertical-align:bottom;
  color: rgb(15, 151, 219);
  font-weight: bold;
  font-size: 25;
}
th {
  height: 60px;
  width:180px;
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
<div align="center" id="d2">
<h1>Assign Bug To Developer</h1>
</div>

<div id="d1" align="center">
<form action="${pageContext.request.contextPath}/assignBug" method="get">

<table border="2">
  <thead>
    <tr>
      <th>Bug Allocated Id</th>
      <th>Project name</th>
      <th>Bug Type</th>
      <th>Bug Status</th>
      <th>Bug Severity</th>
      <th>Description</th>
      <th>Planned Assign Date</th>
      <th>Planned End Date</th>
      <th>Fix Bug</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="k" items="${AssignedBugDetail}">
<tr>
<td>${k.bugAllocateId}</td>
<td>${k.projectObj.pName }</td>
<td>${k.bugTypeObj.bugTypeName}</td>
<td>${k.bugStatusObj.name}</td>
<td>${k.severityObj.sevType}</td>
<td>${k.desc}</td>
<td>${k.plannedStartdate}</td>
<td>${k.plannedEndDate}</td>
<td><a href="${pageContext.request.contextPath}/UpdateBugStatus/${k.bugAllocateId}" class="btn btn-info" role="button">Fix Bug</a></td>
</tr>
</c:forEach>
  </tbody>
</table>
</form>
</div>
<div style="background-color: black;width: 100%;height: 500px;"></div>

</body>
</html>



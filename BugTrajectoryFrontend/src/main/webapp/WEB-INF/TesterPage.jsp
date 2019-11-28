<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="TesterHeader.jsp"></jsp:include>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tester page</title>
<style>
#d1{
background-color: black;

}
#d2{
background-color: rgb(255, 26, 102);
height: 70px;
color:rgb(0, 89, 179)
}
td {
  height: 60px;
  width:500px;
  
  vertical-align:bottom;
  color: rgb(15, 151, 219);
}
th {
  height: 60px;
  width:500px;
  vertical-align: middle;
  
  color: rgb(15, 151, 219);
}
#d3{
height: 400px;
background-color: black;
}
#d3{
width: 100%;
height:450px;
background-color: black;
}

</style>
</head>
<body>
<div align="center" id="d2">
		<h1>Project Allocated</h1>
</div>

<form action="test">

<div align="center" id="d1">
<table border="2">
       <tr>
              <th>Project List</th>
              <th>Allocate</th>
       </tr>
       
       <c:forEach items="${tstproList}" var="prObj">
              <tr>
                     <td>
                           ${ prObj.pName}
                     </td>
                     <td>
                           <a style="width: 60%;text-align: center;" href="BugAllocate/${prObj.pId}" class="btn btn-info" role="button">Allocate Bug</a>
                     </td>
              </tr>
       </c:forEach>
       
       
</table>
</div>
</form>
<div id="d3"></div>


</body>
</html>
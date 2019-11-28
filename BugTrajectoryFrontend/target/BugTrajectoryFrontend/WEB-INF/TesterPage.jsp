<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tester page</title>
</head>
<body>
<div align="center">
		<h1>Welcome ${uObj.role}:- ${uObj.user_Name}</h1>
		<form action="test">


<table>
       <tr>
              <td>Project List</td>
              <td>Allocate</td>
       </tr>
       
       <c:forEach items="${tstproList}" var="prObj">
              <tr>
                     <td>
                           ${ prObj.pName}
                     </td>
                     <td>
                           <a href="BugAllocate/${prObj.pId}">Allocate Bug</a>
                     </td>
              </tr>
       </c:forEach>
       
       
</table>
</form>
</div>


</body>
</html>
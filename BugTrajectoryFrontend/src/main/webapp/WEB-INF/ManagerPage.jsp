<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %> 
<jsp:include page="ManagerHeader.jsp"></jsp:include>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <meta charset="utf-8">
       <meta name="viewport" content="width=device-width, initial-scale=1">
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Manager page</title>

<script language="javascript" type="text/javascript">
function removeSpaces(string) {
 return string.split(' ').join('');
}
</script>
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
<h1>Allocate Project</h1>
</div>

		<c:if test="${not empty msg}">
       		<h2 align="center" style="color: rgb(0, 89, 179);background-color: black;height: 60px;">${msg}</h2>
		</c:if>



<center>
<form action="Manager" method="post">
<div align="center" class="container">
		<table class="table">
		<tr class="table-primary">
			<td class="form-control" style="font-size: 35;">Select Project</td>
			<td><select  name="project" class="form-control" required>
				<option value="0">---------------Select Project---------------</option>
				<c:forEach items="${proList}" var="proValues">
  					<option value="${proValues.pId}">
  					${proValues.pName}
  					</option>
  				</c:forEach>
				</select>
			</td>
		</tr>
		<br><tr><td><br></td></tr>

		
		<tr class="table-primary">
			<td class="form-control">Select Developer</td>
			<td><select name="Developer" class="form-control" multiple="multiple" required>
			<option value="0">---------------Select Developer---------------</option>
				<c:forEach items="${devList}" var="devValues">
  					<option value="${devValues.user_Id}">
  					${devValues.user_Name}
  					</option>
  				</c:forEach>
				</select>
			</td>

		</tr>
		<br><tr><td><br></td></tr>

		
		<tr class="table-primary">
			<td class="form-control">Select Tester</td>
			<td><select name="Tester"  class="form-control" multiple="multiple" required>
			<option value="0">---------------Select Tester---------------</option>
				<c:forEach items="${tstList}" var="tstValues">
  					<option value="${tstValues.user_Id}" >
  					${tstValues.user_Name}
  					</option>
  				</c:forEach>
				</select>
			</td>
		</tr>
		<br><tr><td><br></td></tr>
		</table>
</div>		
<div id="a1">
	<table>
		<tr>
		<td></td>
		<td colspan="2"><input type="submit" value="Allocate" id="btn" class="btn btn-success btn-block" ></td>
		</tr>
		</table>
</div>
<div id="a2">
		<table>
		<tr>
		
	</table>
</div>


</form>
</center>
</body>
</html>
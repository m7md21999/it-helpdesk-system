<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title> Employee home page </title>
 <link rel="stylesheet" type="text/css"           
href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
    <div id="header">
    <h1> HelpDesk System</h1>
	<hr>
	<h3> Tasks </h3>
	<ul>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/employee/updatePersonalInfo/${user.id}">Update Personal Information</a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/employee/makeNewReq/${user.id}">New Request</a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/employee/viewAllReqs/${user.id}">Requests History</a> </li>
	</ul>
	</div>
	
	<hr>
	<div id="container">
	<div id="main">
	
	<table border='1px'>
					<tr>
					<th> Request Id </th>
					<th> Subject </th>
					<th> priority </th>
					<th> Status </th>
					<th> Issued Date </th>
					<th> Request Details </th>
					</tr>
					
				<c:forEach var="req" items="${reqsList}">
				   <tr>  
				   <td>${req.id}</td>  
				   <td>${req.subject}</td>  
				   <td>${req.priority}</td>  
				   <td>${req.status}</td>
				   <td>${req.date}</td>  
				   <td><a href="empRequestDetails/${req.id}">details</a></td>  
				   </tr>  
			   </c:forEach>  
			</table>
	
	</div>
	</div>
    	<div id="footer">
		Copyright &copy; 2019 Mohammed Aldawsari
		<br>
		University of Central Missouri - UCMO
		<br>
		CIS 5690 - Advanced Systems Project
				<br>
		<b><a href="http://localhost:8080/FinalProjectMohammed/logout">Logout</a></b>
        </div>
</body>
</html>
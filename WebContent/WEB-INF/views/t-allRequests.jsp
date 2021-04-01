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
	<h3> Tasks </h3>
	<ul>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/updatePersonalInfo/${user.id}">Update Personal Information</a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/viewAllReqs/${user.id}">Requests History</a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/viewNewestRequests/${user.id}">Newest Requests</a> </li>
	</ul>
	</div>
	<hr>
	<div id="container">
	<div id="main">
	
	<table border='1px'>
					<tr>
					<th> Request Id </th>
					<th> Employee Id </th>
					<th> Subject </th>
					<th> priority </th>
					<th> Status </th>
					<th> Issued Date </th>
					<th> Assigned Date </th>
					<th> Request Details </th>
					</tr>
					
				<c:forEach var="req" items="${reqsList}">
				   <tr>  
				   <td>${req.id}</td>  
				   <td>${req.emp_id}</td>
				   <td>${req.subject}</td>  
				   <td>${req.priority}</td>  
				   <td>${req.status}</td>
				   	<td>${req.assignedDate}</td>
				   <td>${req.date}</td>  
				   <td><a href="techRequestDetails/${req.id}">details</a></td>  
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
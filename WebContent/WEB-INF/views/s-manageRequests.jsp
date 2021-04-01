<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title> supervisor home page </title>
 <link rel="stylesheet" type="text/css"           
href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
    <div id="header">
		<h1> HelpDesk System</h1>
		<hr>
		<h3> Tasks </h3><ul>
		<li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/manageUsers"> Manage Users </a> </li>
		<li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/manageRequests"> Manage Requests </a> </li></ul>
	</div>
	<hr>
	<div id="container">
	
	<div id="subtasks">
   <h3> Request Management Tasks </h3>
			<ul>
		    <li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/newRequests"> New Requests </a> </li>
		    <li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/manageRequests"> New-High Priority Requests </a> </li>
			<li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/highPriortyRequests"> High Priority Requests </a> </li>
			<li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/assignedRequests"> Assigned Requests </a> </li>
			<li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/closedRequests"> Closed Requests </a> </li>
			<li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/allRequests"> All Requests </a> </li>
			</ul>
    </div>
    
	<div id="main">
	<h3> ${msg} </h3>
	<br>
			<table border='1px'>
					<tr>
					<th> Request Id </th>
					<th> Employee's Id </th>
					<th> Subject </th>
					<th> priority </th>
					<th> Status </th>
					<th> Issued Date </th>
					<th> Assign Request </th>
					</tr>
					
				<c:forEach var="req" items="${reqsList}">
				   <tr>  
				   <td>${req.id}</td>  
				   <td>${req.emp_id}</td>
				   <td>${req.subject}</td>  
				   <td>${req.priority}</td>  
				   <td>${req.status}</td>
				   <td>${req.date}</td>  
				   <td><a href="requestdetails/${req.id}">details</a></td>  
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
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

    </div>
    
	<div id="main">
	
			<b> Request id : </b> ${req.id}
			<h3> Technicians </h3>
			<table border="2" width="70%" cellpadding="2">  
			<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Office</th>
<!-- 			<th> Current assigned requests</th> -->
			<th>Assign</th>
			</tr>
			  
			<c:forEach var="user" items="${usersList}">   
			<tr>  
			<td>${user.id}</td>  
			<td>${user.fullname}</td>  
			<td>${user.email}</td>  
			<td>${user.phone}</td>
			<td>${user.office} 
			<td><a href="assgin/${user.id}/${req.id}">Assign</a></td> 
			</tr>  
			</c:forEach>  
			</table>  
			<br/>  
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
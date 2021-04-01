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
	<h3> Tasks </h3>
	<ul>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/employee/updatePersonalInfo/${user.id}">Update Personal Information</a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/employee/makeNewReq/${user.id}">New Request</a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/employee/viewAllReqs/${user.id}">Requests History</a> </li>
	</ul>
	</div>
	<hr>
	
	<div id="container">
	
	<div id="subtasks">
	
	<h3> Request is still in process </h3>
	
	<fieldset> <legend> Technichan </legend>
					email : ${tech.email}
					<br>
					<b>Name: </b> ${tech.fullname}
					<br>
					<b> Phone: </b> ${tech.phone}
					<br>
					<b> Office: </b> ${tech.office}
					<br>
					<b>Request assigned date : </b> ${req.assignedDate}
					<br>
					* if empty , the request hasn't been assigned yet!
					
				</fieldset>
					<br>
	
    </div>
    
	<div id="main">
				<fieldset> <legend> Request</legend>
					<b> Request id </b> : ${req.id}
					<br>
					Request subject : ${req.subject}
					<br>
					Request description : ${req.description}
					<br>
					Request priority : ${req.priority}
					<br>
					Request status : ${req.status}
					<br>
					Request date : ${req.date}
					<br>
					</fieldset>
				<br>
								<table> <tr>
				<th> <a href="deleteRequest/${req.id}"> <b>Delete</b></a> </th>
				</tr>
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
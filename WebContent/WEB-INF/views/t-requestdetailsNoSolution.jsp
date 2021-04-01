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
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/updatePersonalInfo/${user.id}">Update Personal Information</a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/viewAllReqs/${user.id}">Requests History</a> </li>
		</ul>
	</div>
	<hr>
	
	<div id="container">
	
	<div id="subtasks">
	
				<fieldset> <legend> Employee </legend>
					email : ${emp.email}
					<br>
					<b>Name: </b> ${emp.fullname}
					<br>
					<b> Phone: </b> ${emp.phone}
					<br>
					<b> Office: </b> ${emp.office}
					<br>
				</fieldset>
					<br>
					
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
					Request Assigned Date : ${req.assignedDate}
					<br>
					</fieldset>
				<br>
    </div>
    
	<div id="main">
	
	<h2> Request Report :</h2>
	<h4> Fill a report once you are done with the request.</h4>
	<br>
				<table> <tr>
				<th> <a href="closeRequest/${req.id}"> Close request <b></b></a> </th>
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
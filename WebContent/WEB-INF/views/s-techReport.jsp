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
	
				<fieldset> <legend> technician  </legend>
					<b>email : </b> ${tech.email}
					<br>
					<b>Name: </b> ${tech.fullname}
					<br>
					<b> Phone: </b> ${tech.phone}
					<br>
					<b> Office: </b> ${tech.office}
					<br>
				</fieldset>
					<br>
    </div>
    
	<div id="main">
				<fieldset> <legend> Report</legend>
					<br>
					<br>
					Description : <br>
					 ${reqSol.description}
					<br>
					Finish date : ${reqSol.finishDate}
					<br>
					</fieldset>
				<br>

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
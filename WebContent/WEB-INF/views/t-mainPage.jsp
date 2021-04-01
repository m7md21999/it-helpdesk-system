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
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/updatePersonalInfo/${user.id}"> Update personal information </a> </li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/viewAllReqs/${user.id}"> Requests history</a></li>
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/viewNewestRequests/${user.id}">Newest Requests</a> </li>
	</ul>
	</div>
	
	<hr>
	<div id="container">
	<div id="main">
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
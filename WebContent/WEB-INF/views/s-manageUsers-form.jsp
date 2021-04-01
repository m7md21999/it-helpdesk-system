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
    <h3> Users Management Tasks </h3>
        <ul>
        <li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/addNewUser"> Add new User </a> </li>
        <li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/allUsersList"> View All Users </a> </li>
        <li> <a href="http://localhost:8080/FinalProjectMohammed/supervisor/allUsersListDept"> View Users By Department </a> </li>
        </ul>
    </div>
    
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
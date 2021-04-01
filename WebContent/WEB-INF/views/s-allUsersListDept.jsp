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
		<b> Department </b>
		<form action="showUsersDept">
				Supervisor <input type="radio" name="dept_name" value="Supervisors"/><br>
				Information technology <input type="radio" name="dept_name" value="Information technology"/><BR>
				Human resources <input type="radio" name="dept_name" value="Human resources"/><br>
				Administration <input type="radio" name="dept_name" value="Administration"/><br>
				Finance <input type="radio" name="dept_name" value="Finance"/><br>
				Marketing <input type="radio" name="dept_name" value="Marketing"/><br>
				<button type="submit">Display</button>
		 </form>
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
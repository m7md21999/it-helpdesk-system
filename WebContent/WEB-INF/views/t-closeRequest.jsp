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
	<li> <a href="http://localhost:8080/FinalProjectMohammed/technician/viewNewestRequests/${user.id}">Newest Requests</a> </li>
	</ul>
	</div>
	<hr>
	
	<div id="container">
	
	<div id="subtasks">
    </div>
    
	<div id="main">
	
	<h2> Request Report :</h2>
	<form:form action="confirmCloseRequest/${req_id}" modelAttribute="reqSol" mehtod="post">
	describe in no more than 35 letters/ less than 5 letters how the request has been solved :
	<br>
<%-- 	<form:hidden path="req_id" value="${req_id}"/> --%>
	<br>
	<form:textarea path="description"/>
	<br>
	<form:errors path="description" cssClass="error"/>
	<br>
	<button type="submit"> Submit</button>
	</form:form>
	
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
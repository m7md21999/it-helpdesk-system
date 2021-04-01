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
		<li> <a href="manageUsers"> Manage Users </a> </li>
		<li> <a href="manageRequests"> Manage Requests </a> </li></ul>
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
			<fieldset><legend> Enter User's Information </legend>                
		    <form:form action='addUserConfirmation' modelAttribute="user">     
		    <b> Email : </b> <form:input path="email"></form:input>
		    <form:errors path="email" cssClass="error"/>
		    <br>
		    <b> Password : </b> <form:password path="password"/>
		    <form:errors path="password" cssClass="error"></form:errors>
		    
		    <br>
		    <b> Full name :</b> <form:input path="fullname"/>
		    <form:errors path="fullname" cssClass="error"></form:errors>
		    
		    <br>
		    <b> Phone # : </b> <form:input path="phone"/>
		    <form:errors path="phone" cssClass="error"></form:errors>
		    <br>
		    <b> Office # : </b> <form:input path="office"/>
		    <form:errors path="office" cssClass="error"></form:errors>
		    <br>
		    <b> Department </b> <br>
		   Supervisor <input type="radio" name="dept_name" value="Supervisors"/><br>
		   Information technology <form:radiobutton path="dept_name" value="Information technology"/><BR>
		   Human resources <form:radiobutton path="dept_name" value="Human resources"/><br>
		   Administration <form:radiobutton path="dept_name" value="Administration"/><br>
		   Finance <form:radiobutton path="dept_name" value="Finance"/><br>
		   Marketing <form:radiobutton path="dept_name" value="Marketing"/><br>
		   <form:errors path="dept_name" cssClass="error"></form:errors>
		   <button type="submit"> Add</button>
		    </form:form>
		    </fieldset>
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
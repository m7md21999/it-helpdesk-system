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
	<div id="main">
				<h5> New Request Form </h5>
				 <fieldset><legend> Enter Information </legend>                
		     <form:form action='http://localhost:8080/FinalProjectMohammed/employee/makeNewReq/createReqConfirmation' modelAttribute="newReq"> 
		     <form:hidden path="emp_id" value="${user_id}"></form:hidden> 
		     <br>   
		    <b> Subject : </b> <form:input path="subject"></form:input>
		              		    <form:errors path="subject" cssClass="error"></form:errors>
		    
		    <br>
		    <b> Description :(No more than 30 letters *Not required) </b><br> <form:textarea path="description"/>
		              		    <form:errors path="description" cssClass="error"></form:errors>
		    
		    <br>
		    <br>
		    <b> Priority </b>
			    <form:select path ="priority">
			    <form:option value="Low">Low</form:option>
			    <form:option value="Normal">Normal</form:option>
			   	<form:option value="High">High</form:option>
			    </form:select>
			    <form:errors path="priority"/>
		    <br>
		    <form:hidden path="status"/>
		   <button type="submit"> Make Request </button>
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
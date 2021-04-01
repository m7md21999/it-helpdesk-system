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
	<h1>Edit Employee</h1>  
       <form:form action="http://localhost:8080/FinalProjectMohammed/employee/updatePersonalInfo/empconfirmUpdate" modelAttribute="user" method="POST" >    
        <table>    
        <tr> 
        
         <td><form:hidden path="id"/></td>
         </tr>   
         <tr>    
          <td>email : </td>   
          <td><form:input path="email"  /></td> 
          		    <form:errors path="email" cssClass="error"/>
           
         </tr>    
         <tr>    
          <td>fullname :</td>    
          <td><form:input path="fullname" /></td> 
           		    <form:errors path="fullname" cssClass="error"></form:errors>
           
         </tr>   
         <tr>    
          <td>password :</td>    
          <td><form:input path="password" /></td>  
          		    <form:errors path="password" cssClass="error"></form:errors>
          
         </tr>  
          <tr>    
          <td>phone :</td>    
          <td><form:input path="phone" /></td>  
          		    <form:errors path="phone" cssClass="error"></form:errors>
          
         </tr> 
         <tr>    
          <td>Office :</td>    
          <td><form:input path="office" /></td> 
          		    <form:errors path="office" cssClass="error"></form:errors>
           
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr> 
          <tr> 
         <td><form:hidden path="dept_name"/></td>
         </tr>    
        </table>    
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
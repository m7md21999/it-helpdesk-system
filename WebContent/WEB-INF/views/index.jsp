<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>IT Help desk System </title>
</head><link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/style.css">
<body>
	<div id="header">
	<h1> HelpDesk System</h1>
	</div>
		 <div id="container">
            <div id="main">
            <br>
            <h1> Welcome ${msg}</h1>
            <br>
            	<h2> Login Page</h2>
				<form action ="supervisorLogin">
				Email : <input type="email" name="email" >
				<br>
				<br>
				Password : <input type="password" name="password">
				<br>
				<br>
				<button type="submit"> Login </button>
				</form>
		
            </div> 
            
        </div>
    	<div id="footer">
		Copyright &copy; 2019 Mohammed Aldawsari
		<br>
		University of Central Missouri - UCMO
		<br>
		CIS 5690 - Advanced Systems Project
        </div>
</body>
</html>
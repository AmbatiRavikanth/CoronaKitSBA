<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit Order Management Portal</title>
</head>
<body>
<jsp:include page="Header.jsp" />

<c:if test="${Newuser != true }"> 
<form action="Newuser">
		<div><Strong>ENTER NEW USER DETAILS: </Strong></div>
		<hr/>
		<br/>
		<div>  
            <label>User Name</label>  
            <input type="text" name="username" placeholder="Enter Anonymous User Name" required/>  
        </div>  
        <br/>
        <div>  
            <label>Email ID</label>  
            <input type="text" name="email" placeholder="Enter email id" required/>  
        </div> 
        <br/>
        <div>  
            <label>Contact Number</label>  
            <input type="number" name="contact" placeholder="Enter contact number" required/>  
        </div>
        <br/>
        <button>Next</button>
</form>
 </c:if>

<c:if test="${Newuser == true }"> 
        
        <p><strong>Welcome ${Newusername}</strong></p>  
        <hr />  
    <nav>      
    	<br/>    
        <a href="showProductstoadd">Show products to add</a>               
    </nav> 
        
 </c:if> 

<jsp:include page="Footer.jsp" /> 
</body>
</html>
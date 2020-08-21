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
<jsp:include page="Header.jsp"/>
<c:if test="${LoginSuccess != true }"> 
<form action="AdminLogin">
		<div><Strong>ENTER ADMIN CREDENTIALS: </Strong></div>
		<hr/>
		<br/>
		<div>  
            <label>User ID</label>  
            <input type="text" name="userid" placeholder="Enter User ID" required/>  
        </div> 
        <br/> 
        <div>  
            <label>Password</label>  
            <input type="text" name="password" placeholder="Enter Password" required/>  
        </div> 
        <br/>
        <button>Login</button>
</form>
 </c:if>
<c:if test="${LoginSuccess == true }"> 
        
        <p><strong>Welcome ${username}</strong></p>  
        <hr />  
    <nav>          
        <a href="listProducts">Products List</a>  
        <span>|</span>  
        <a href="newProduct">Add Product</a> 
        <span>|</span>  
        <a href="Logout">Logout</a>          
    </nav> 
        
 </c:if> 
 <c:if test="${msg != null }">  
        <p><strong>${msg }</strong></p>  
  </c:if> 
 <jsp:include page="Footer.jsp"/> 
</body>
</html>
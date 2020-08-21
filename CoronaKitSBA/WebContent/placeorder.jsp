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
<c:if test="${Addresssubmitted != true }"> 
<form action="placeorder">
		<div><Strong>Enter Shipping Address: </Strong></div>
		<hr/>
		<br/>
		<div>  
            <label>Address Line1 :</label>  
            <input type="text" name="Address1" placeholder="Enter Address 1" required/>  
        </div>  
        <br/>
        <div>  
            <label>Address Line1 :</label>  
            <input type="text" name="Address2" placeholder="Enter Address 2" required/>  
        </div>
        <br/>
        <div>  
            <label>City :</label>  
            <input type="text" name="City" placeholder="Enter City" required/>  
        </div>
        <br/>
        <div>  
            <label>State :</label>  
            <input type="text" name="State" placeholder="Enter State" required/>  
        </div>
        <br/>
        <button>Submit Address</button>
</form>
 </c:if>

<c:if test="${Addresssubmitted == true }"> 
	<div><Strong>Shipping Address: </Strong></div>
	<hr/>
	<br/>
	<div>Address1:${Address1}</div>
	<br/>
	<div>Address2:${Address2}</div>
	<br/>
	<div>City:${City}</div>
	<br/>
	<div>State:${State}</div>
	<br/>
	
	
	<nav>   
		<br/>       
        <a href="ordersummary">View Order Summary</a>               
 	</nav> 

 </c:if>


<jsp:include page="Footer.jsp" /> 
</body>
</html>
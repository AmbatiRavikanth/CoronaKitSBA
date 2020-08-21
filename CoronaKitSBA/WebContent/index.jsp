<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

<jsp:include page="Header.jsp"/>
<br/>
<h1>WELCOME TO HOME PAGE</h1>
<br/>
 <c:if test="${msg != null }">  
        <p><strong>${msg }</strong></p> 
        <br/> 
 </c:if>  

<jsp:include page="Footer.jsp"/>
</body>
</html>
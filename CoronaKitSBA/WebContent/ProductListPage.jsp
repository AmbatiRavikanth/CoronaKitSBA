<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit Order Management Portal</title>
</head>
<body>
	<jsp:include page="Header.jsp" /> 
	
	 <nav>           
        <a href="listProducts">Products List</a>  
        <span>|</span>  
        <a href="newProduct">Add Product</a>  
        <span>|</span>  
        <a href="Logout">Logout</a>         
    </nav>
    <br/>
	<c:if test="${deleteconfirmationmsg!=null}">
	<p> Product is Deleted.</p>
	<br/>
	</c:if>
	 <c:choose>  
        <c:when test="${productlist == null || productlist.isEmpty() }">  
            <p>No Products Available to display</p>  
        </c:when>  
        <c:otherwise>  
            <table border="1" cellspacing="5px" cellpadding="5px">  
                <tr>  
                    <th>Product id#</th>  
                    <th>Product Name</th>  
                    <th>Product Cost</th>  
                    <th>Product Description</th>   
                    <th>Actions</th>                    
                </tr>  
                <c:forEach items="${productlist}" var="product">  
                    <tr>  
                        <td>${product.id }</td>  
                        <td>${product.productName }</td>  
                        <td>${product.cost }</td>  
                        <td>${product.productDescription}</td>                        
                        <td>
                        <a href="deleteProduct?id=${product.id}">DELETE</a>
                        <a href="editProduct?id=${product.id}">EDIT</a>
                        </td>
                    </tr>  
                </c:forEach>  
            </table>  
        </c:otherwise>  
    </c:choose>  
	
	
	<jsp:include page="Footer.jsp" /> 
</body>
</html>
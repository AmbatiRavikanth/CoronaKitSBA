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

<hr /> 
        
<c:choose>  
        <c:when test="${productlist == null || productlist.isEmpty() }">  
            <p>No Products Available to display</p>  
        </c:when>  
        <c:otherwise>  
        	<p>Add Products from below listed table & click on 'Show Added Products in kit' link</p>  
			<br/> 
			<strong>Click on 'Add Product to cart' again to increase the Quantity.</strong>
			<br/> 
			<br/>
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
                       <a onclick="showText('text1')" href="addproductstocart?id=${product.id}">Add Product to cart</a> 
                       
                        </td>
                    </tr>  
                </c:forEach>  
            </table>  
        </c:otherwise>  
    </c:choose> 
    
   <nav>   
   		<br/>       
        <a href="showkit">Show Added Products in kit</a>               
    </nav> 

<jsp:include page="Footer.jsp" /> 
</body>
</html>
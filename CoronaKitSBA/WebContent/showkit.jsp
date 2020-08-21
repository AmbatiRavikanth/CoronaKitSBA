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

<br/>         
<c:choose>  
        <c:when test="${cartaddedproduct == null || cartaddedproduct.isEmpty() }">  
            <p>No Products has been added to Cart</p>  
        </c:when>  
        <c:otherwise>  
        <p>Below listed Products are added to cart click on Place Order link to Submit the order </p> 
        <br/>
            <table border="1" cellspacing="5px" cellpadding="5px">  
                <tr>  
                    <th>Product id#</th>  
                    <th>Product Name</th>  
                    <th>Product Cost</th>  
                    <th>Product Description</th>         
                    <th>Product Quantity</th>                                 
                </tr>  
                <c:forEach items="${cartaddedproduct}" var="product">  
                    <tr>  
                        <td>${product.id }</td>  
                        <td>${product.productName }</td>  
                        <td>${product.cost }</td>  
                        <td>${product.productDescription}</td>               
                        <td>${Qtymap.get(product.id)}</td>     
                    </tr>  
                </c:forEach>  
            </table>  
            <nav>
		   		<br/>          
		        <a href="placeorder.jsp">Place Order</a>               
   			 </nav> 
        </c:otherwise>  
    </c:choose> 
    
   
<br/>
<jsp:include page="Footer.jsp" /> 
</body>
</html>
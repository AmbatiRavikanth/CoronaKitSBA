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
<h2 align="center">ORDER SUMMARY</h2>
<hr/>
<h3>USER DETAILS</h3>

<div>USER NAME:${Newusername}</div>
<div>EMAIL ID:${Newuseremail}</div>
<div>CONTACT NUMBER:${Newusercontact}</div>
<br/>
<hr/>
<h4>ADDRESS DETAILS</h4>

<div>ADDRESS LINE 1:${Address1}</div>
<div>ADDRESS LINE 2:${Address2}</div>
<div>CITY:${City}</div>
<div>STATE:${State}</div>
<br/>
<hr/>
<h4>ITEMS SUMMARY</h4>

<c:choose>  
        <c:when test="${cartaddedproduct == null || cartaddedproduct.isEmpty() }">  
            <p>No Products has been added to Cart</p>  
        </c:when>  
        <c:otherwise>  
        
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
        </c:otherwise>  
    </c:choose>
    <br/>
<hr/>
<br/>
<h4>TOTAL COST: ${TotalAmount} INR</h4>
<br/>
<jsp:include page="Footer.jsp" /> 
</body>
</html>
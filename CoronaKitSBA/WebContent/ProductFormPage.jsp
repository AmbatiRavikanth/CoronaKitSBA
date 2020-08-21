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

	<nav>           
        <a href="listProducts">Products List</a>  
        <span>|</span>  
        <a href="newProduct">Add Product</a>  
        <span>|</span>  
        <a href="Logout">Logout</a>         
    </nav>
	<br/>
   <h3>${isNew?'Add New Product':'Edit Product' }</h3>  	
    <form action="${isNew?'addProduct':'saveProduct' }" method="post">  
    <br/>
        <div>  
            <label>Product id</label>  
            <input type="number" name="productid" value="${product.id }" required ${isNew?'':'readonly' }/>  
        </div>  
    <br/>        
		<div> 
            <label>Product Name</label>  
            <input type="text" name="productName" value="${product.productName }" required />  
        </div> 
    <br/>         
        <div>  
            <label>Product Cost</label>  
            <input type="decimal" name="cost" value="${product.cost }" required />  
        </div>
    <br/>          
        <div>  
            <label>Product Description</label>  
            <input type="text" name="productDescription" value="${product.productDescription }"  />  
        </div>  
    <br/>                               
        <button>SAVE</button> 
    <br/>             
    </form>  


<jsp:include page="Footer.jsp"/>
</body>
</html>
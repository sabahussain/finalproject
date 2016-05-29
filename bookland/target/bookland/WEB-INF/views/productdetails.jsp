<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${a}/bootstrap.min.css" rel="stylesheet"/>
 <script src="${b}/jquery-2.2.3.min.js">
 </script>
<script src="${b}/bootstrap.min.js">
</script>
<style>
body {
    background-color: #FFE4E1;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #FFE4E1;">
<jsp:include page="header.jsp"></jsp:include>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
          

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Image</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Author</th>
                <th>Price</th>
              
            </tr>
            </thead>
             
                <tr>
                    <td><img src="${z}/humour.jpg" style="width:100%;"/></td>
                    <td>${p.name}</td>
                    <td>${p.category}</td>
                    <td>${p.author}</td>
                    <td>${p.price} </td>
                </tr>
         
        </table>

        <a href="<spring:url value="/cartview" />" class="btn btn-primary">Add Product</a>
        </table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${a}/bootstrap.min.css" rel="stylesheet"/>
 <script src="${b}/jquery-2.2.3.min.js">
 </script>
<script src="${b}/bootstrap.min.js">
</script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
        .h1{padding-top:60px;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #FFE4E1;">

<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

<jsp:include page="header.jsp"/>
<div class="container" style="padding-left:200px"> 
  <h1>
    Add a Product
</h1>
<c:url var="addAction" value="/admin/add" ></c:url>
<form:form action="${addAction}" commandName="product" modelAttribute="product" method="post">
<table>
    <c:if test="${!empty product.name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" /></td>
            <td><form:errors path="name" cssClass="error" cssStyle="color: #ff0000;"/></td>
            
     
    </tr>
    <tr>
        <td>
            <form:label path="author">
                <spring:message text="Author"/>
            </form:label>
        </td>
        <td>
            <form:input path="author" />
        </td> <td><form:errors path="author" cssClass="error" cssStyle="color: #ff0000;"/></td>
    </tr>
     <tr>
        <td>
            <form:label path="description">
                <spring:message text="Description"/>
            </form:label>
        </td>
        <td>
            <form:input path="description" />
        </td> <td><form:errors path="description" cssClass="error" cssStyle="color: #ff0000;"/></td>
    </tr>
     <tr>
        <td>
            <form:label path="price">
                <spring:message text="Price"/>
            </form:label>
        </td>
        <td>
            <form:input path="price" /> <td><form:errors path="price" cssClass="error" cssStyle="color: #ff0000;"/></td>
        </td>
    </tr>
     <tr>
        <td>
            <form:label path="category">
                <spring:message text="Category"/>
            </form:label>
        </td>
        <td>
            <form:input path="category" />  <td><form:errors path="category" cssClass="error" cssStyle="color: #ff0000;"/></td>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty product.name}">
                <input type="submit"
                    value="<spring:message text="Edit Product"/>" />
            </c:if>
           
                <input type="submit"
                    value="<spring:message text="Add Product"/>" />
         
        </td>
    </tr>
</table>  
</form:form>
</div>

                     <div class="container" style="padding-top:60px;padding-left:200px;"> 
                     
                         <div class="form-group form-group-sm">
                          <div class="col-sm-10">
                          <input type="text" class="form-control" placeholder="Search"  ng-model="searchBooks">
                           </div>
                           </div>
                           </div>

<br>
 <div class="container" style="padding-left:200px">
  <h3>Product List</h3>
<c:if test="${!empty listproduct}">
    <div class="container" style="padding-top:20px">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Author</th>
        <th width="120">Description</th>
        <th width="120">Price</th>
        <th width="120">Category</th>
        
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
   <c:forEach items="${listproduct}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.author}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            <td><a href="<c:url value='/edit/${product.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${product.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
    </div>
</c:if>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:form="http://www.springframework.org/tags/form">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content">
			<fieldset>
				<legend>Member Home Page</legend>
				
				<a href="home.obj">Home</a>
				<br /><br />
				<h2>
				Welcome ${userBean.userId }</h2>
				<br/>
			</fieldset>
		</div>
</body>
</html>
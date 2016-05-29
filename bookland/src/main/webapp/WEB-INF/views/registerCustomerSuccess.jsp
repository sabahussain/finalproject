<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer registered successfully!</h1>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<spring:url value="/productdetails" />" class="btn btn-default">Products</a></p>
        </section>

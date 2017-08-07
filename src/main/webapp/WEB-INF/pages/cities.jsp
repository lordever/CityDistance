<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Cities</title>
    <c:import url="fragments/head.jsp"/>
</head>
<body>
<c:if test="${! empty cities}">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>City A</th>
                    <th>City B</th>
                    <th>Distance</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <tr>
                    <c:forEach items="${cities}" var="city">
                <tr>
                    <td>${city.id}</td>
                    <td>${city.cityA}</td>
                    <td>${city.cityB}</td>
                    <td>${city.distance}</td>
                    <td><a href="<c:url value='/edit/${city.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/remove/${city.id}'/>">Delete</a></td>
                </tr>
                </c:forEach>
            </table>
            <a href="<c:url value="/index.jsp"/>" class="btn btn-info" role="button">To main</a>
        </div>
    </div>
</c:if>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <h1>Add new city</h1>
        <c:url var="addAction" value="/cities/add"/>
        <form:form action="${addAction}" commandName="city">
            <div class="form-group">
                <label for="id">ID</label>
                <form:input path="id" id="id" class="form-control" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="CityA">First City</label>
                <form:input path="cityA" id="CityA" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="CityB">Second City</label>
                <form:input path="cityB" id="CityB" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="distance">Distance</label>
                <form:input path="distance" id="distance" class="form-control"/>
            </div>
            <button class="btn btn-default">Save</button>
        </form:form>
    </div>
</div>
</body>
</html>

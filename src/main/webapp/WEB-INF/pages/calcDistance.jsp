<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc Distance</title>
    <c:import url="fragments/head.jsp"/>
</head>
<body>
<div class="container">
    <c:if test="${! empty cities}">
        <div class="row" id="jsTable">
            <div class="col-md-6 col-md-offset-3">
                <table class="table">
                    <tr>
                        <th>City A</th>
                        <th>City B</th>
                        <th>Distance</th>
                    </tr>
                    <tr>
                        <c:forEach items="${cities}" var="city">
                    <tr>
                        <td>${city.cityA}</td>
                        <td>${city.cityB}</td>
                        <td>${city.distance}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </c:if>
    <c:if test="${empty cities}">
        <h2 class="text-center">None cities</h2>
    </c:if>
    <div class="row">
        <h2 class="text-center">Calculate distance between cities</h2>
        <c:url value="/calcDistance" var="calcAction" />
    </div>
    <div class="row">
        <a href="<c:url value="/cities"/>" class="btn btn-primary">Add City</a>
        <a href="<c:url value="/index.jsp"/>" class="btn btn-warning">Cancel</a>
    </div>
</div>
</body>
</html>

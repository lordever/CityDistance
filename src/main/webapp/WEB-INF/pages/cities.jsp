<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities</title>
    <c:import url="fragments/head.jsp" />
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
                    <td><a href="#">Edit</a></td>
                    <td><a href="#">Delete</a></td>
                </tr>
                </c:forEach>
                </tr>
            </table>
        </div>
    </div>
</c:if>
</body>
</html>

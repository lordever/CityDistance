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

<div class="container" style="min-height: 500px">
    <c:if test="${! empty cities}">
        <div class="row" id="jsTable">
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
                        <td><a href="<c:url value='cities/rest/edit/${city.id}'/>">Edit</a></td>
                        <td><a href="<c:url value='cities/rest/remove/${city.id}'/>">Delete</a></td>
                    </tr>
                    </c:forEach>
                </table>
                <a href="<c:url value="/index.jsp"/>" class="btn btn-info">To main</a>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1>Add new city</h1>
            <c:url var="addAction" value="/cities/rest/add"/>
            <form action="${addAction}">
                <div class="form-group jsIdForm">
                    <label class="control-label" for="id">ID</label>
                    <input class="form-control" id="id" name="id" readonly size="8" disabled value="${city.id}"/>
                    <input class="form-control" name="id" type="hidden"/>
                </div>
                <div class="form-group">
                    <label class="control-label" for="jsCityA">First City</label>
                    <input class="form-control jsCityA" id="jsCityA" name="cityA" value="${city.cityA}"/>
                </div>
                <div class="form-group jsCityBForm">
                    <label class="control-label" for="jsCityB">Second City</label>
                    <input class="form-control jsCityB" id="jsCityB" name="cityB" value="${city.cityB}"/>
                </div>
                <div class="form-group jsDistanceForm">
                    <label class="control-label" for="jsDistance">Distance</label>
                    <input class="form-control jsDistance" id="jsDistance" name="distance" value="${city.distance}"/>
                </div>
                <c:if test="${!empty city.cityA}">
                    <button class="btn btn-default jsEditBtn" type="button">Edit</button>
                </c:if>
                <c:if test="${empty city.cityA}">
                    <button class="btn btn-default jsSaveBtn" type="button">Save</button>
                </c:if>
            </form>
        </div>
    </div>

    <div id="feedback"></div>
</div>
</body>
</html>

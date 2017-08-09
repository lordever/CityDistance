<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Cities</title>
    <c:import url="fragments/head.jsp"/>
    <script src="<c:url value="/resources/content/js/addComponent/jsAddComponent.js"/>" type="text/javascript"></script>
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
                        <td><a href="<c:url value='/edit/${city.id}'/>">Edit</a></td>
                        <td><a href="<c:url value='/rest/remove/${city.id}' />" class="jsDeleteLink">Delete</a></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </c:if>
    <div class="row" id="jsForm">
        <div class="col-md-6 col-md-offset-3">
            <h2 class="text-center">Add new city</h2>
            <c:url var="addAction" value="/rest/post"/>
            <form action="${addAction}">
                <div class="form-group jsIdForm">
                    <label class="control-label" for="jsCityId">ID</label>
                    <input class="form-control" id="jsCityId" name="id" readonly size="8" disabled value="${city.id}"/>
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
                    <button class="btn btn-primary jsEditBtn" type="button">Edit</button>
                    <a href="<c:url value="/cities"/>" class="btn btn-default">To add new City</a>
                </c:if>
                <c:if test="${empty city.cityA}">
                    <button class="btn btn-primary jsSaveBtn" type="button">Save</button>
                </c:if>
                <a href="<c:url value="/index.jsp"/>" class="btn btn-warning">Cancel</a>
                <a href="<c:url value="/calcDistance"/>" class="btn btn-success">Calculate Distance</a>
            </form>
        </div>
    </div>

    <div id="feedback"></div>
</div>
</body>
</html>

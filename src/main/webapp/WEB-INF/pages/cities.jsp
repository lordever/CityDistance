<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Cities</title>
    <c:import url="fragments/head.jsp"/>
    <script src="<c:url value="/resources/content/js/cityRedactorComponent/jsCityRedactorComponent.js"/>"
            type="text/javascript"></script>
</head>
<body>

<div class="container" style="min-height: 500px">
    <div class="row justify-content-md-center" id="jsTable">
        <div class="col-md-6 col-md-offset-3">
            <table class="table jsCitiesTableRedactor">
                <tr>
                    <th>ID</th>
                    <th>City A</th>
                    <th>City B</th>
                    <th>Distance</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </table>
        </div>
    </div>
    <div class="row justify-content-md-center" id="jsForm">
        <div class="col-md-6 col-md-offset-3">
            <h2 class="text-center">Add new city</h2>
            <form>
                <div class="form-group jsIdForm">
                    <label class="control-label" for="jsCityId">ID</label>
                    <input class="form-control jsCityId" id="jsCityId" name="id" readonly size="8" disabled
                           value=""/>
                    <input class="form-control" name="id" type="hidden"/>
                </div>
                <div class="form-group">
                    <label class="control-label" for="jsCityA">First City</label>
                    <input class="form-control jsCityA" id="jsCityA" name="cityA" value=""/>
                </div>
                <div class="form-group jsCityBForm">
                    <label class="control-label" for="jsCityB">Second City</label>
                    <input class="form-control jsCityB" id="jsCityB" name="cityB" value=""/>
                </div>
                <div class="form-group jsDistanceForm">
                    <label class="control-label" for="jsDistance">Distance</label>
                    <input class="form-control jsDistance" id="jsDistance" name="distance" value=""/>
                </div>
                <div class="show additionBlock">
                    <button class="btn btn-primary jsSaveBtn" type="button">Save</button>
                    <a href="<c:url value="/index.jsp"/>" class="btn btn-warning">Cancel</a>
                    <a href="<c:url value="/calcDistance"/>" class="btn btn-success">Calculate Distance</a>
                </div>
                <div class="editBlock sr-only">
                    <button class="btn btn-primary jsEditBtn" type="button">Edit</button>
                    <button class="btn btn-default toAdditionCity">To add new City</button>
                    <a href="<c:url value="/index.jsp"/>" class="btn btn-warning">Cancel</a>
                    <a href="<c:url value="/calcDistance"/>" class="btn btn-success">Calculate Distance</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

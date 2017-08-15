<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc Distance</title>
    <c:import url="fragments/head.jsp"/>
    <script src="<c:url value="/resources/content/js/calcComponent/jsCalcComponent.js"/>"
            type="text/javascript"></script>
    <link rel="stylesheet" href="<c:url value="/resources/content/styles/style.css"/>"/>
</head>
<body>
<div class="container" style="min-height: 500px">
    <div class="row" id="jsTable">
        <div class="col-md-6 col-md-offset-3">
            <table class="table jsCitiesTableCalc">
                <tr>
                    <th>City A</th>
                    <th>City B</th>
                    <th>Distance</th>
                </tr>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h2 class="text-center">Calculate distance between cities</h2>
            <form>
                <div class="form-group">
                    <label class="control-label" for="jsCityA">First City</label>
                    <input class="form-control jsCityFrom" id="jsCityA" name="cityA"/>
                </div>
                <div class="form-group jsCityBForm">
                    <label class="control-label" for="jsCityB">Second City</label>
                    <input class="form-control jsCityTo" id="jsCityB" name="cityB"/>
                </div>
                <button class="btn btn-success jsCalc" type="button">Calculate</button>
            </form>
            <a href="<c:url value="/cities"/>" class="btn btn-primary">Add City</a>
            <a href="<c:url value="/index.jsp"/>" class="btn btn-warning">Cancel</a>
        </div>
    </div>
    <div class="sr-only resultContainer">
        <div class="jumbotron resultBotron">
            <h2>Result!</h2>
        </div>
    </div>
</div>
</body>
</html>

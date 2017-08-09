<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <c:import url="WEB-INF/pages/fragments/head.jsp" />

</head>
<body>
    <h1>Hello User.</h1>
    <a href="<c:url value="/cities"/>" class="btn btn-primary">Cities</a>
    <a href="<c:url value="/calcDistance"/>" class="btn btn-success">Calc Distance</a>
</body>
</html>
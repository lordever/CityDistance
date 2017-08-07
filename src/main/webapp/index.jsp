<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <c:import url="WEB-INF/pages/fragments/head.jsp" />
</head>
<body>
    <h1>Hello world</h1>
    <a href="<c:url value="/cities" />">Cities</a>
</body>
</html>
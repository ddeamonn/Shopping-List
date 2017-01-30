<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href= <c:url value="/resources/css/styles.css" /> rel="stylesheet" type="text/css">
    <title>JSP page</title>
</head>
<body>
    <%@include file="menu.jsp" %>
    <h1>${requestScope.info}</h1>
    <a href="/doViewshoplists">Return to orders page</a>
</body>
</html>

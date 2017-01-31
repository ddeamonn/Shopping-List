<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href= <c:url value="/resources/css/styles.css" /> rel="stylesheet" type="text/css">
    <title>shoplist report viewer</title>
</head>
<body>

    <%@include file="menu.jsp" %>

    <h4 align="center">List of shops by period</h4>
    <form action="/doViewShoplist" method="post">
        <table align="center">
            <tr>
                <td colspan="2"><b>User Orders:</b></td>
            </tr>
            <tr>
                <td>
                    <select name="orders">
                    <c:forEach var="order" items="${requestScope.report}">
                        <option value="${order.shoplistID}">${order.shoplistName}</option>
                    </c:forEach>
                </select>
                </td>
                <td><input type="submit" value="view order"><td>
            </tr>
        </table>
    </form>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href= <c:url value="/resources/css/styles.css" /> rel="stylesheet" type="text/css">
    <title>Registration</title>
</head>
<body>
<form action="/doRegistration" method="post">
    <table align="center">
        <tr>
            <td colspan="2" align="center"><b>Registration</b></td>
        </tr>
        <tr>
            <td>email:</td><td><input type="text" name="customerMail"></td>
        </tr>
        <tr>
            <td>password:</td><td><input type="text" name="customerPassword"></td>
        </tr>
        <tr>
            <td><input type="submit" value="register"><td>
        </tr>
    </table>
</form>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/doRegistration" method="post">
    <table>
        <tr>
            <td><b>Registration</b></td>
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

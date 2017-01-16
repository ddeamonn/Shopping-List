<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Shopping list record</title>
</head>
<body>

<h1>Shopping list record</h1>
    <table>

        <tr><td>Shoplist Name:</td><td><input type="text" name="shoplistName" value="${requestScope.data.shoplistName}" readonly></td>

        <tr><td colspan="2">

        <table id="products">
        <tr>
            <th>Products</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <tbody>

        <c:forEach var="order" items="${requestScope.data.orderItemsDTO}">
            <tr>
                <td><input type="text" name="productName" value="${order.product.productName}" readonly></td>
                <td><input type="text" name="productQty" value="${order.productQty}" readonly></td>
                <td><input type="text" name="productPrice" value="${order.productPrice}" readonly></td>
            </tr>
        </c:forEach>

        </tbody>
        </table>

        </td></tr>
    </table>
</body>
</html>

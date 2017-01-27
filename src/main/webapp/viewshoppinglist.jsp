<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Shopping list record</title>
</head>
<body>

<h1>Shopping list record</h1>
<form method="post">
    <table>

        <tr><td align="right">Shoplist Name:</td>
            <td>
                <input type="text" name="shoplistName" value="${requestScope.record.shoplistName}" readonly>
                <input type="hidden" name="shoplistID" value="${requestScope.record.shoplistID}" readonly>
            </td>

        <tr><td colspan="2">

        <table id="products">
        <tr>
            <th>Purchased</th>
            <th>Products</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <tbody>

        <c:forEach var="order" items="${requestScope.record.orderItemsDTO}" varStatus="loop">
            <tr>
                <td align="center">
                    <c:choose>
                        <c:when test="${order.purchaseStatus eq 'on'}">
                            <input type="checkbox" name="${'productStatus'.concat(loop.index)}" value="on" checked>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="${'productStatus'.concat(loop.index)}" value="on">
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><input type="text" name="productName" value="${order.product.productName}" readonly></td>
                <td><input type="text" name="productQty" value="${order.productQty}" readonly></td>
                <td>
                    <input type="text" name="productPrice" value="${order.productPrice}" readonly>
                    <input type="hidden" name="orderItemID" value="${order.orderID}" readonly>
                </td>
                <td align="center"><b>EUR</b></td>
            </tr>
        </c:forEach>

        </tbody>
        </table>

        </td></tr>
        <tr>
            <td align="center" colspan="2">
            <table>
                <tr>
                <td><input type="submit" value="update" name="update" onclick="form.action='/doUpdateShoplist';"></td>
                <td><input type="submit" value="delete" name="delete" onclick="form.action='/doDeleteShoplist';"></td>
                </tr>
            </table>
            </td>
        </tr>
    </table>
</form>

<script>
    function changevalue(check) {
        check.value = check.checked;
    };
</script>

</body>
</html>


<h1>Product</h1>
<table>
    <tr>
        <th>Products</th>
    </tr>

    <c:forEach var="product" items="${requestScope.data}">
        <tr>
            <td>${product.productName}</td>
        </tr>
    </c:forEach>
</table>

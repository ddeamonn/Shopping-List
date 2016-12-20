
<h1>Product</h1>
<table>
    <tr>
        <th>Products</th>
    </tr>

    <tr>
        <td>
        <select name="product">
            <c:forEach var="product" items="${requestScope.data}">
                <option value="${product.productId}">${product.productName}</option>
            </c:forEach>
        </select>
        </td>
        <td>Quantity:<input type="text" name="pqty"></td>
    </tr>
</table>

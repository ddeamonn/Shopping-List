<h1>Login:</h1>

<form action="/doLogging" method="post">
<table>
    <tr>
    <td>email:</td><td><input type="text" name="customerMail"></td>
    </tr>
    <tr>
    <td>password:</td><td><input type="text" name="customerPassword"></td>
    </tr>
    <tr><td><a href="/registration">registration</a></td></tr>
</table>
</form>


<h1>Shopping list</h1>
<form action="/addShoplist" method="post">
    <table>

        <tr><td>Shoplist Name:</td><td><input type="text" name="shoplistName"></td>
        <tr>
            <th>Products</th>
            <th>Quantity</th>
        </tr>

        <tr>
            <td>
                <select name="products">
                    <c:forEach var="product" items="${requestScope.data}">
                        <option value="${product.productName}">${product.productName}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="text" name="pqty"></td>
        </tr>
        <tr>
            <td>
                <select name="products">
                    <c:forEach var="product" items="${requestScope.data}">
                        <option value="${product.productName}">${product.productName}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="text" name="pqty"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="save shop"><td>
        </tr>
    </table>
</form>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping list page</title>
</head>
<body>

<script language="JavaScript">
    function add_fields(divName, inpName, inpQty, inpPrice) {
        var tableRef = document.getElementById(divName).getElementsByTagName('tbody')[0];

        // Insert a row in the table at the last row
        var newRow   = tableRef.insertRow(tableRef.rows.length);

        // Insert a cell in the row at index 0
        var newCell  = newRow.insertCell(0);

        // Append a text node to the cell
        var element  = document.createElement("input");
        //Assign different attributes to the element.
        element.setAttribute("type", "text");
        element.setAttribute("value", "");
        element.setAttribute("name", inpName);
        newCell.appendChild(element);

        // Insert a cell in the row at index 0
        var newCell1  = newRow.insertCell(1);

        // Append a delete button to the cell
        var element1  = document.createElement("input");
        //Assign different attributes to the element.
        element1.setAttribute("type", "text");
        element1.setAttribute("value", "");
        element1.setAttribute("name", inpQty);
        newCell1.appendChild(element1);

        // Insert a cell in the row at index 0
        var newCell2  = newRow.insertCell(2);

        // Append a delete button to the cell
        var element2  = document.createElement("input");
        //Assign different attributes to the element.
        element2.setAttribute("type", "text");
        element2.setAttribute("value", "");
        element2.setAttribute("name", inpPrice);
        newCell2.appendChild(element2);

        // Insert a cell in the row at index 0
        var newCell3  = newRow.insertCell(3);

        // Append a delete button to the cell
        //var element2  = document.createElement("input");
        //Assign different attributes to the element.
       // element2.setAttribute("type", "text");
        //element2.setAttribute("value", "");
        //element2.setAttribute("name", inpPrice);
        newCell3.innerHTML = "<b>EUR</b>";
        newCell3.style.textAlign = "center";
    }

    function deleteLastRow(tableId) {
        var table = document.getElementById(tableId);
        var rowCount = table.rows.length;
        if (rowCount>2) {
            table.deleteRow(rowCount -1);
        }
    }

    function deleteThisRow(row, tableID){
        var d = row.parentNode.parentNode.rowIndex;
        document.getElementById(tableID).deleteRow(d);
    }
</script>

<a href="/reports.jsp"><b>Reports</b></a>

<form action="/doViewShoplist" method="post">
<table>
    <tr>
        <td colspan="2"><b>User Orders:</b></td>
    </tr>
    <tr>
        <td>
            <select name="orders">
                <c:forEach var="order" items="${requestScope.data}">
                    <option value="${order.shoplistID}">${order.shoplistName}</option>
                </c:forEach>
            </select>
        </td>
        <td><input type="submit" value="view order"><td>
    </tr>
</table>
</form>

<h1>Shopping list</h1>
<form action="/addShoplist" method="post">
    <table>

        <tr><td>Shoplist Name:</td><td><input type="text" name="shoplistName"></td>
        <tr><td colspan="2">
            <table><tr>
            <td><input type="button" id="more_fields"
                       onclick="add_fields('products', 'productName', 'productQty', 'productPrice');"
                       value="+" />
            </td>
            <td>
                <input type="button" id="delete"
                       onclick="deleteLastRow('products');" value="-" />
            </td>
            </tr></table>
            </td>
        </tr>

        <tr><td colspan="2">

        <table id="products">
        <tr>
            <th>Products</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Currency</th>
        </tr>
        <tbody>
        <tr>
            <td><input type="text" name="productName"></td>
            <td><input type="text" name="productQty"></td>
            <td><input type="text" name="productPrice"></td>
            <td align="center"><b>EUR</b></td>
        </tr>
        </tbody>
        </table>

        </td></tr>
        <tr>
            <td colspan="2"><input type="submit" value="save shop"><td>
        </tr>
    </table>
</form>
</body>
</html>

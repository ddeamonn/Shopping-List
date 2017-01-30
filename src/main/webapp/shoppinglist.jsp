<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href= <c:url value="/resources/css/styles.css" /> rel="stylesheet" type="text/css">
    <title>Shopping list page</title>
</head>
<body>

<script language="JavaScript">
    function add_fields(divName, inpName, inpQty, inpPrice) {

        var table = document.getElementById(divName);
        var rowCount = table.rows.length;

        var tableRef = document.getElementById(divName).getElementsByTagName('tbody')[0];

        // Insert a row in the table at the last row
        var newRow   = tableRef.insertRow(tableRef.rows.length);

        // Insert a cell in the row at index 0
        var newCell0  = newRow.insertCell(0);

        // Append a text node to the cell
        var element0  = document.createElement("input");
        //Assign different attributes to the element.
        element0.setAttribute("type", "checkbox");
        element0.setAttribute("value", "on");
        element0.setAttribute("name", "productStatus");

        newCell0.style.textAlign = "center";
        newCell0.appendChild(element0);

        // Insert a cell in the row at index 0
        var newCell  = newRow.insertCell(1);

        // Append a text node to the cell
        var element  = document.createElement("input");
        //Assign different attributes to the element.
        element.setAttribute("type", "text");
        element.setAttribute("value", "");
        element.setAttribute("name", inpName);
        newCell.appendChild(element);

        // Insert a cell in the row at index 0
        var newCell1  = newRow.insertCell(2);

        // Append a delete button to the cell
        var element1  = document.createElement("input");
        //Assign different attributes to the element.
        element1.setAttribute("type", "text");
        element1.setAttribute("value", "0");
        element1.setAttribute("name", inpQty);
        newCell1.appendChild(element1);

        // Insert a cell in the row at index 0
        var newCell2  = newRow.insertCell(3);

        // Append a delete button to the cell
        var element2  = document.createElement("input");
        //Assign different attributes to the element.
        element2.setAttribute("type", "text");
        element2.setAttribute("value", "0.00");
        element2.setAttribute("name", inpPrice);
        newCell2.appendChild(element2);

        // Insert a cell in the row at index 0
        var newCell3  = newRow.insertCell(4);

        // Append a delete button to the cell
        //var element2  = document.createElement("input");
        //Assign different attributes to the element.
       // element2.setAttribute("type", "text");
        //element2.setAttribute("value", "");
        //element2.setAttribute("name", inpPrice);
        newCell3.innerHTML = "<b>EUR</b>";
        newCell3.style.textAlign = "center";

        refreshCheckbox();

    }

    function deleteLastRow(tableId) {
        var table = document.getElementById(tableId);
        var rowCount = table.rows.length;
        if (rowCount>2) {
            table.deleteRow(rowCount -1);
            refreshCheckbox();
        }
    }

    function deleteThisRow(row, tableID){
        var d = row.parentNode.parentNode.rowIndex;
        document.getElementById(tableID).deleteRow(d);
    }

    function refreshCheckbox() {
        var table = document.getElementById("products");
        var rowCount = table.rows.length;
        for (var i = 0, row; row = table.rows[i]; i++) {
            var checkbox = row.cells[0];
            if (i>0 ) {
                var element = checkbox.childNodes[0];
                element.setAttribute("name", "productStatus"+(i-1));
            }
        }
    }
</script>

<%@include file="menu.jsp" %>


<form action="/addShoplist" method="post">
    <h4 align="center">New shopping list</h4>
    <table align="center" frame="box" >

        <tr><td align="center" colspan="2" >Shoplist Name:<input type="text" name="shoplistName"></td>
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

        <tr><td>

        <table id="products">
        <tr>
            <th align="center">Purchased</th>
            <th>Products</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Currency</th>
        </tr>
        <tbody>
        <tr>
            <td align="center"><input type="checkbox" name="productStatus0" value="on"></td>
            <td><input type="text" name="productName"></td>
            <td><input type="text" name="productQty" value = "0"></td>
            <td><input type="text" name="productPrice" value = "0.00"></td>
            <td align="center"><b>EUR</b></td>
        </tr>
        </tbody>
        </table>

        </td></tr>
        <tr>
            <td><input type="submit" value="save" name="save"><td>
        </tr>
    </table>
</form>
</body>
</html>

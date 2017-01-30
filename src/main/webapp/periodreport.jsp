<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <link href= <c:url value="/resources/css/styles.css" /> rel="stylesheet" type="text/css">
    <link href= <c:url value="/resources/css/ion.calendar.css" /> rel="stylesheet" type="text/css">
    <title>Reports</title>
</head>

<body>

    <%@include file="menu.jsp" %>

    <h4 align="center">Report by period</h4>
    <form action="/doViewPeriodReport" method="post">
        <table align="center">
            <tr>
            <td>start date:</td>
         	<td><input type="text" value="" name="startDate" id="startDate" data-lang="en" data-years="2015-2035" data-format="YYYY-MM-DD" required />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src=<c:url value="/resources/js/moment-with-locales.min.js"/> ></script>
		<script src=<c:url value="/resources/js/ion.calendar.js"/> ></script>
		<script>
            $(function(){
                $("#startDate").ionDatePicker();
            });
        </script>
            </td>
		<td>end date:</td>
		<td>
        <input type="text" value="" name="endDate" id="endDate" data-lang="en" data-years="2015-2050" data-format="YYYY-MM-DD" required/>
		<script>
            $(function(){
                $("#endDate").ionDatePicker();
            });
        </script>
		</td>
            </tr>
            <tr>
                <td><input type="submit" value="view report" name="view"><td>
            </tr>
        </table>
    </form>
</body>
</html>

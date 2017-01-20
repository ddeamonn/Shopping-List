<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <link href="css/ion.calendar.css" rel="stylesheet" type="text/css">
    <title>Reports</title>
</head>
<body>
    <h1>Report by period</h1>
    <form action="/doViewPeriodReport" method="post">
        <table>
            <td>start date:</td>
         	<td><input type="text" value="" name="startDate" id="startDate" data-lang="en" data-years="2015-2035" data-format="YYYY-MM-DD" required />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="js/moment-with-locales.min.js"></script> 
		<script src="js/ion.calendar.js"></script> 
		<script>$(function(){$("#startDate").ionDatePicker();});</script></td>
		<td>end date:</td>
		<td><input type="text" value="" name="endDate" id="endDate" data-lang="en" data-years="2015-2050" data-format="YYYY-MM-DD" required/>
		<script>$(function(){$("#endDate").ionDatePicker();});</script>
		</td>
            <tr>
                <td><input type="submit" value="view report"><td>
            </tr>
        </table>
    </form>
</body>
</html>

<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <style>
       <%--
       <%@include file="/WEB-INF/css/style.css" %>
       --%>
    </style>
</head>

<body>
    <div>
        <form method="post" action="/start">
            <h1>Start</h1>
            <select name="map">
                <option value="1">Map 1</option>
                <option value="2">Map 2</option>
            </select>
            <input type="submit" name="Send" value="Send">
        </form>
    </div>
</body>

</html>
<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <style>
        <%@include file="/css/styles.css" %>
    </style>
</head>

<body id= "start-body">
    <div id="start">
        <h1>SELECT YOUR MAP</h1>
        <form method="post" action="/start" >
            <select name="map">
                <option value="1">Map 1</option>
                <option value="2">Map 2</option>
            </select>
            <input type="submit" name="Send" value="Send">
        </form>
    </div>
</body>

</html>
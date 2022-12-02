<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
        <%@include file="/css/styles.css" %>
    </style>
</head>
<body>
<h1>INTRODUCE YOUR NAME</h1>
<div id="endForm">
<form method="post" action="/endform">
<input type="text" name="Winner">
<input type="submit" value="SEND">
</form>
</div>
</body>
</html>
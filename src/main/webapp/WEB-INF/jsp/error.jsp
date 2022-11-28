<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
        <%@include file="/css/styles.css" %>
    </style>
</head>
<body id=error-body>
<h1 id=error>ERROR DETECTED</h1>
<h2 id=error-message>${error}</h2>
</body>
</html>
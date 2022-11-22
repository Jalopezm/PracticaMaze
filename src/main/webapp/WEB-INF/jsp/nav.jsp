<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<style>
        <%@include file="/css/styles.css" %>
    </style>
</head>

<body>
<canvas id="canvas" style="border:1px solid #000000;" width="1134px" height="486px"></canvas>
</body>
<script type="application/json" id="myjson">
${myjson}
</script>
<script src="js/javaScript.js"></script>
</html>
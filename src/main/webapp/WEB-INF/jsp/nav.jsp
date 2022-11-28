<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<style>
        <%@include file="/css/styles.css" %>
    </style>
</head>

<body id="nav-body">
<canvas id="canvas" style="border:1px solid #000000;" width="1134px" height="486px"></canvas>
<div id="reset-div">
<button id="reset" onclick="reset()">RESET</button>
</div>
</body>
<script type="application/json" id="myjson">
${myjson}
</script>
<script src="js/javaScript.js"></script>
</html>
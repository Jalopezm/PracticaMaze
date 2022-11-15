<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>

</head>

<body>
<canvas style="border:1px solid #000000;" width="800px" height="600" ></canvas>
</body>
<script type="application/json">
${myjson}
</script>
<script>
let dataScript = document.getElemetById("").textContent;
let data = JSON.parse(dataScript);

</script>
</html>
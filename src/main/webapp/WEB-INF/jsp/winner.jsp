<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
        <table>
            <thead>
                <tr>
                    <th>Winner Name</th>
                    <th>Maze Name</th>
                    <th>Total Time</th>
                </tr>
            </thead>
    <c:forEach var="winner" items="${winnersList}">
        <tbody>
            <tr>
                <td>${winner.getWinnerName()}</td>
                <td>${winner.getMazeSolved()}</td>
                <td>${winner.getTime()}</td>
            </tr>
    </c:forEach>
    </tbody>
    </table>
    </body>
</html>
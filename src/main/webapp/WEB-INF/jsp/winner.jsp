<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
        <%@include file="/css/styles.css" %>
    </style>
</head>
<body>
<h1>HALL OF FAME</h1>
<div class="datagrid";>
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
                <td>${winner.getTimeFormatted()}</td>
            </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    </body>
</html>
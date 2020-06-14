<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tours Application</title>
</head>
<body>

    <h1>Tours Management</h1>
    <h2>
        <a href="<%=request.getContextPath()%>/new">Add New Tour</a>
        &nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/list">List All Tour</a>

    </h2>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Tours1</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Location</th>
            <th>Transport</th>
            <th>Nutrition</th>
            <th>Duration</th>
            <th>Price</th>
        </tr>
        <c:forEach var="tour" items="${listTours}">
            <tr>
                <td><c:out value="${tour.id}" /></td>
                <td><c:out value="${tour.tourTitle}" /></td>
                <td><c:out value="${tour.tourLocation}" /></td>
                <td><c:out value="${tour.tourTransport}" /></td>
                <td><c:out value="${tour.tourNutrition}" /></td>
                <td><c:out value="${tour.tourDuration}" /></td>
                <td><c:out value="${tour.tourPrice}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${tour.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${tour.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
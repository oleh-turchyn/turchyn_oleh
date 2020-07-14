<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tours Application</title>
    <style>
        body {
            background: linear-gradient(to bottom, #72eb78, #36da95);
            color: #fff;
            line-height: 1.6;
            font-family: 'Montserrat', sans-serif;
            padding: 1em;
        }

        .nav_link{
            color: #fff;
            text-decoration: none;
            transition: color .1s linear;
        }

        .nav_link:hover{
            color: #333333;
        }

        .crud_link{
            color: #0081cc;
            text-decoration: none;
        }

        .container {
            max-width: 800px;
            margin-left: auto;
            margin-right: auto;
            padding: 1em;
        }

        .tours {
            background: #f9feff;
            color: #000;
            border-collapse: collapse;
            text-align: center;
            border: 1px solid #fff;
        }

        .caption{
            color: #fff;
        }

        th, td:first-child {
            background: #f1c836;
            color: white;
            padding: 10px 20px;
        }

        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: #2c3734;
        }

        td {
            background: #f9feff;
        }

        th:first-child, td:first-child {
            text-align: left;
        }
    </style>
</head>
<body>

    <h1>Tours Management</h1>
    <h2>
        <a class="nav_link" href="<%=request.getContextPath()%>/tour/new">Add New Tour</a>
        &nbsp;&nbsp;&nbsp;
        <a class="nav_link" href="<%=request.getContextPath()%>/tour/list">List All Tour</a>
        &nbsp;&nbsp;&nbsp;
        <a class="nav_link" href="<%=request.getContextPath()%>/">Main Page</a>

    </h2>

<div class="container" align="center">
    <table class="tours" border="1" cellpadding="5">
        <caption><h2 class="caption">List of Tours</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Location</th>
            <th>Transport</th>
            <th>Nutrition</th>
            <th>Duration</th>
            <th>Price</th>
            <th>Modify</th>
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
                    <a class="crud_link" href="<%=request.getContextPath()%>/tour/edit?id=<c:out value='${tour.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="crud_link" href="<%=request.getContextPath()%>/tour/delete?id=<c:out value='${tour.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
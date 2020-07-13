<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 7/11/2020
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tours Application</title>
    <style>
        body {
        <%--background: url(${pageContext.servletContext.contextPath}res\images\tab8.jpg) no-repeat center top / cover;--%>
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
            /* border-radius: 15px; */
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
            border-color: white;
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

<h1>Orders Details</h1>
<h2>
<%--    <a href="<%=request.getContextPath()%>/orderDetail/list">List of Details</a>--%>
</h2>
<div class="container" align="center">
    <table class="tours" border="1" cellpadding="5">
        <caption><h2 class="caption">List of Order Details</h2></caption>
        <tr>
            <th>ID</th>
            <th>Order date</th>
            <th>Client name</th>
            <th>Client surname</th>
            <th>Tour title</th>
        </tr>
        <c:forEach var="orderDetail" items="${listOrderDetails}">
            <tr>
                <td><c:out value="${orderDetail.orderId}" /></td>
                <td><c:out value="${orderDetail.dateOrder}" /></td>
                <td><c:out value="${orderDetail.clientName}" /></td>
                <td><c:out value="${orderDetail.clientSurname}" /></td>
                <td><c:out value="${orderDetail.titleTour}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

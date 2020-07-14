<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 7/10/2020
  Time: 5:33 PM
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
            background: linear-gradient(to bottom, #72eb78, #36da95);
            color: #fff;
            line-height: 1.6;
            font-family: 'Montserrat', sans-serif;
            padding: 1em;
        }
        .crud_link{
            color: #0081cc;
            text-decoration: none;
        }
        .nav_link{
            color: #fff;
            text-decoration: none;
            transition: color .1s linear;
        }
        .nav_link:hover{
            color: #333333;
        }

        .container {
            max-width: 800px;
            margin-left: auto;
            margin-right: auto;
            padding: 1em;
        }

        .orders {
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

<h1>Orders Management</h1>
<h2>
    <a class="nav_link" href="<%=request.getContextPath()%>/order/new">Add New Order</a>
    &nbsp;&nbsp;&nbsp;
    <a class="nav_link" href="<%=request.getContextPath()%>/order/list">List All Order</a>
    &nbsp;&nbsp;&nbsp;
    <a class="nav_link" href="<%=request.getContextPath()%>/orderDetail/list">Details of orders</a>
    &nbsp;&nbsp;&nbsp;
    <a class="nav_link" href="<%=request.getContextPath()%>/">Main Page</a>

</h2>

<div class="container" align="center">
    <table class="orders" border="1" cellpadding="5">
        <caption><h2 class="caption">List of Orders</h2></caption>
        <tr>
            <th>ID</th>
            <th>Order date</th>
            <th>Client code</th>
            <th>Tour code</th>
            <th>Modify</th>
        </tr>
        <c:forEach var="order" items="${listOrders}">
            <tr>
                <td><c:out value="${order.id}" /></td>
                <td><c:out value="${order.dateOrder}" /></td>
                <td><c:out value="${order.clientCode}" /></td>
                <td><c:out value="${order.tourCode}" /></td>
                <td>
                    <a class="crud_link" href="<%=request.getContextPath()%>/order/edit?id=<c:out value='${order.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="crud_link" href="<%=request.getContextPath()%>/order/delete?id=<c:out value='${order.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

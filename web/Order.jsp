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
</head>
<body>

<h1>Orders Management</h1>
<h2>
    <a href="<%=request.getContextPath()%>/order/new">Add New Order</a>
    &nbsp;&nbsp;&nbsp;
    <a href="<%=request.getContextPath()%>/order/list">List All Order</a>

</h2>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Orders</h2></caption>
        <tr>
            <th>ID</th>
            <th>Order date</th>
            <th>Client name</th>
            <th>Client surname</th>
            <th>Tour title</th>
        </tr>
        <c:forEach var="order" items="${listOrders}">
            <tr>
                <td><c:out value="${order.orderId}" /></td>
                <td><c:out value="${order.dateOrder}" /></td>
                <td><c:out value="${order.clientName}" /></td>
                <td><c:out value="${order.clientSurname}" /></td>
                <td><c:out value="${order.titleTour}" /></td>
                <td>
                    <a href="<%=request.getContextPath()%>/order/edit?id=<c:out value='${order.orderId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="<%=request.getContextPath()%>/order/delete?id=<c:out value='${order.orderId}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

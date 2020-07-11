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
</head>
<body>

<h1>Orders Details</h1>
<h2>
<%--    <a href="<%=request.getContextPath()%>/orderDetail/list">List of Details</a>--%>
</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Order Details</h2></caption>
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

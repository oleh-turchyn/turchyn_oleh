<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 6/23/2020
  Time: 5:37 PM
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

<h1>Clients Management</h1>
<h2>
    <a href="<%=request.getContextPath()%>/client/new">Add New Client</a>
    &nbsp;&nbsp;&nbsp;
    <a href="<%=request.getContextPath()%>/client/list">List All Clients</a>

</h2>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Clients</h2></caption>
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last Name</th>
            <th>Patronymic</th>
            <th>Passport</th>
            <th>Telephone number</th>
        </tr>
        <c:forEach var="client" items="${listClients}">
            <tr>
                <td><c:out value="${client.id}" /></td>
                <td><c:out value="${client.firstName}" /></td>
                <td><c:out value="${client.lastName}" /></td>
                <td><c:out value="${client.patrName}" /></td>
                <td><c:out value="${client.passport}" /></td>
                <td><c:out value="${client.telNumber}" /></td>
                <td>
                    <a href="<%=request.getContextPath()%>/client/edit?id=<c:out value='${client.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="<%=request.getContextPath()%>/client/delete?id=<c:out value='${client.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

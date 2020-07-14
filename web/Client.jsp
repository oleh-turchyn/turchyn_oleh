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
        .caption{
            color: #fff;
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

        .client {
            background: #f9feff;
            color: #000;
            border-collapse: collapse;
            text-align: center;
            border: 1px solid #fff;
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

<h1>Clients Management</h1>
<h2>
    <a class="nav_link" href="<%=request.getContextPath()%>/client/new">Add New Client</a>
    &nbsp;&nbsp;&nbsp;
    <a class="nav_link" href="<%=request.getContextPath()%>/client/list">List All Clients</a>
    &nbsp;&nbsp;&nbsp;
    <a class="nav_link" href="<%=request.getContextPath()%>/">Main Page</a>

</h2>

<div class="container" align="center">
    <table class="client" border="1" cellpadding="5">
        <caption><h2 class="caption">List of Clients</h2></caption>
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last Name</th>
            <th>Patronymic</th>
            <th>Passport</th>
            <th>Telephone number</th>
            <th>Modify</th>
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
                    <a class="crud_link" href="<%=request.getContextPath()%>/client/edit?id=<c:out value='${client.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="crud_link" href="<%=request.getContextPath()%>/client/delete?id=<c:out value='${client.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

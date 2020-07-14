<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 6/20/2020
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>tour Store Application</title>
    <style>
        body {
            background: linear-gradient(to bottom, #72eb78, #36da95);
            color: #fff;
            line-height: 1.6;
            font-family: 'Montserrat', sans-serif;
            padding: 1em;
        }

        .container {
            max-width: 500px;
            margin-left: auto;
            margin-right: auto;
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

        .client_form {
            background: #f9feff;
            color: #000;
        }

        .client_form form {
            color: #000;
        }

        .client_form form p {
            margin: 0;
        }

        .client_form form label{
            margin: 5px;
        }

        .client_form form input {
            width: 95%;
            padding: 1em;
            border: 1px solid #36da95;
        }

        .client_form form .submit {
            margin: 10px 0 10px 0;
            background: #b6b6b6;
            color: #fff;
            border: 0;
            font-size: 1rem;
            text-transform: uppercase;
        }

        .client_form form .submit:hover,
        .client_form form .submit:focus {
            background: #f1c836;
            color: #fff;
            outline: 0;
            transition: background-color 1;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="title">Clients</h1>
    <h2>
        <a class="nav_link" href="<%=request.getContextPath()%>/client/list">List All Clients</a>
        &nbsp;&nbsp;&nbsp;
        <a class="nav_link" href="<%=request.getContextPath()%>/">Main Page</a>
    </h2>
    <h2>
        <c:if test="${client != null}">
            Edit client
        </c:if>
        <c:if test="${client == null}">
            Add New client
        </c:if>
    </h2>
    <div class="client_form" align="center">
        <c:if test="${client != null}">
        <form action="update" method="post">
            </c:if>
            <c:if test="${client == null}">
            <form action="insert" method="post">
                </c:if>
                <c:if test="${client != null}">
                    <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                </c:if>
                <p>
                    <label>First name</label>
                    <input type="text" name="title" size="45" value="<c:out value='${client.firstName}' />">
                </p>
                <p>
                    <label>Last name</label>
                    <input type="text" name="location" size="45" value="<c:out value='${client.lastName}' />">
                </p>
                <p>
                    <label>Patronymic</label>
                    <input type="text" name="transport" size="45" value="<c:out value='${client.patrName}' />">
                </p>
                <p>
                    <label>Passport</label>
                    <input type="text" name="nutrition" size="45"  value="<c:out value='${client.passport}' />">
                </p>
                <p>
                    <label>Telephone number</label>
                    <input name="duration" rows="5" size="45" value="<c:out value='${client.telNumber}' />">
                </p>
                <p>
                    <input type="submit" value="Save" class="submit" />
                </p>
            </form>
    </div>
</div>

</body>
</html>


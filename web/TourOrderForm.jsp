<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 7/10/2020
  Time: 9:45 PM
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
            /*background: url(../verstka/images/forest2.jpg) no-repeat center top / cover;*/
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
        .center{
            display: flex;
            justify-content: center;
        }
        .order_form {
            background: #f9feff;
            color: #000;
            /*border-radius: 15px;*/
        }

        .order_form form {
            /*display: grid;*/
            /*grid-template-columns: 1fr 1fr;*/
            /*grid-gap: 20px;*/
            color: #000;
        }

        /*.tour_form form label {*/
        /*    display: block;*/
        /*}*/

        .order_form form p {
            margin: 0;
        }

        .order_form form input {
            width: 100%;
            padding: 1em;
            /* border:1px solid #c9e6ff;   */
            border: 1px solid #36da95;
        }

        .order_form form .submit {
            background: #b6b6b6;
            color: #fff;
            border: 0;
            font-size: 1rem;
            text-transform: uppercase;
        }

        .order_form form .submit:hover,
        .order_form form .submit:focus {
            background: #f1c836;
            color: #fff;
            outline: 0;
            transition: background-color 1;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="title">Orders</h1>
    <h2>
        <a class="nav_link" href="<%=request.getContextPath()%>/order/new">Add New Order</a>

        <a class="nav_link" href="<%=request.getContextPath()%>/order/list">List All Order</a>

    </h2>
    <h2>
        <c:if test="${order != null}">
            Edit order
        </c:if>
        <c:if test="${order == null}">
            Add New order
        </c:if>
    </h2>
    <div class="order_form" align="center">
        <c:if test="${order != null}">
        <form action="update" method="post">
            </c:if>
            <c:if test="${order == null}">
            <form action="insert" method="post">
                </c:if>
                <c:if test="${order != null}">
                    <input type="hidden" name="id" value="<c:out value='${order.id}' />" />
                </c:if>
                <p>
                    <label>Order date:</label>
                    <input type="text" name="title" size="45" value="<c:out value='${order.dateOrder}' />">
                </p>
                <p>
                    <label>Client code:</label>
                    <input type="text" name="location" size="45"  value="<c:out value='${order.clientCode}' />">
                </p>
                <p>
                    <label>Tour code:</label>
                    <input type="text" name="transport" size="45" value="<c:out value='${order.tourCode}' />">
                </p>
                <p>
                    <input type="submit" value="Save" class="submit" />
                </p>
            </form>
    </div>
</div>

</body>
</html>
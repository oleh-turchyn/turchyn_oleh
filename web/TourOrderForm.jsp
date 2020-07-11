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
</head>
<body>

<h1>Tours</h1>
<h2>
    <a href="<%=request.getContextPath()%>/order/new">Add New Order</a>

    <a href="<%=request.getContextPath()%>/order/list">List All Orders</a>

</h2>

<div align="center">
    <c:if test="${order != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${order == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${order != null}">
                            Edit orderDetail
                        </c:if>
                        <c:if test="${order == null}">
                            Add new orderDetail
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${order != null}">
                    <input type="hidden" name="id" value="<c:out value='${order.id}' />" />
                </c:if>
                <tr>
                    <th>Order date: </th>
                    <td>
                        <input type="text" name="date_order" size="45"
                               value="<c:out value='${order.dateOrder}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Client code: </th>
                    <td>
                        <input type="text" name="client_code" size="45"
                               value="<c:out value='${order.clientCode}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Tour code: </th>
                    <td>
                        <input type="text" name="tour_code" size="45"
                               value="<c:out value='${order.tourCode}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

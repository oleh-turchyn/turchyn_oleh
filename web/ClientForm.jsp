<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 6/20/2020
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%><%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>tour Store Application</title>
</head>
<body>

<h1>Clients</h1>
<h2>
    <a href="<%=request.getContextPath()%>/client/new">Add New Client</a>
    &nbsp;&nbsp;&nbsp;
    <a href="<%=request.getContextPath()%>/client/list">List All Clients</a>

</h2>

<div align="center">
    <c:if test="${client != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${client == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${client != null}">
                            Edit client
                        </c:if>
                        <c:if test="${client == null}">
                            Add New client
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${client != null}">
                    <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                </c:if>
                <tr>
                    <th>First name: </th>
                    <td>
                        <input type="text" name="first_name" size="45"
                               value="<c:out value='${client.firstName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Last name: </th>
                    <td>
                        <input type="text" name="last_name" size="45"
                               value="<c:out value='${client.lastName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Patronymic: </th>
                    <td>
                        <input type="text" name="patron_name" size="45"
                               value="<c:out value='${client.patrName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Passport: </th>
                    <td>
                        <input type="text" name="passport" size="45"
                               value="<c:out value='${client.passport}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Telephone number: </th>
                    <td>
                        <input type="text" name="tel_num" size="45"
                               value="<c:out value='${client.telNumber}' />"
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


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
        <a href="<%=request.getContextPath()%>/new">Add New Tour</a>
        &nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/list">List All Books</a>

    </h2>

<div align="center">
    <c:if test="${tour != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${tour == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${tour != null}">
                            Edit tour
                        </c:if>
                        <c:if test="${tour == null}">
                            Add New tour
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${tour != null}">
                    <input type="hidden" name="id" value="<c:out value='${tour.id}' />" />
                </c:if>
                <tr>
                    <th>Title: </th>
                    <td>
                        <input type="text" name="tourTitle" size="45"
                               value="<c:out value='${tour.tourTitle}' />"
                            />
                    </td>
                </tr>
                <tr>
                    <th>Location: </th>
                    <td>
                        <input type="text" name="tourLocation" size="45"
                               value="<c:out value='${tour.tourLocation}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Transport: </th>
                    <td>
                        <input type="text" name="tourTransport" size="5"
                               value="<c:out value='${tour.tourTransport}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Nutrition: </th>
                    <td>
                        <input type="text" name="tourNutrition" size="5"
                               value="<c:out value='${tour.tourNutrition}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Duration: </th>
                    <td>
                        <input type="text" name="tourDuration" size="5"
                               value="<c:out value='${tour.tourDuration}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price: </th>
                    <td>
                        <input type="text" name="tourPrice" size="5"
                               value="<c:out value='${tour.tourPrice}' />"
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

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

        .tour_form {
            background: #f9feff;
            color: #000;
        }

        .tour_form form {
            color: #000;
        }

        .tour_form form p {
            margin: 0;
        }

        .tour_form form label {
            margin: 5px;
        }

        .tour_form form input {
            width: 95%;
            padding: 1em;
            /* border:1px solid #c9e6ff;   */
            border: 1px solid #36da95;
        }

        .tour_form form .submit {
            margin: 10px 0 10px 0;
            background: #b6b6b6;
            color: #fff;
            border: 0;
            font-size: 1rem;
            text-transform: uppercase;
        }

        .tour_form form .submit:hover,
        .tour_form form .submit:focus {
            background: #f1c836;
            color: #fff;
            outline: 0;
            transition: background-color 1;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="title">Tours</h1>
    <h2>
        <a class="nav_link" href="<%=request.getContextPath()%>/tour/list">List All Tours</a>
        &nbsp;&nbsp;&nbsp;
        <a class="nav_link" href="<%=request.getContextPath()%>/">Main Page</a>
    </h2>
    <h2>
        <c:if test="${tour != null}">
            Edit tour
        </c:if>
        <c:if test="${tour == null}">
            Add New tour
        </c:if>
    </h2>
    <div class="tour_form" align="center">
        <c:if test="${tour != null}">
        <form action="update" method="post">
            </c:if>
            <c:if test="${tour == null}">
            <form action="insert" method="post">
                </c:if>
                    <c:if test="${tour != null}">
                        <input type="hidden" name="id" value="<c:out value='${tour.id}' />" />
                    </c:if>
                    <p>
                        <label>Title</label>
                        <input type="text" name="title" size="45" value="<c:out value='${tour.tourTitle}' />">
                    </p>
                    <p>
                        <label>Location</label>
                        <input type="text" name="location" size="45" value="<c:out value='${tour.tourLocation}' />">
                    </p>
                    <p>
                        <label>Transport</label>
                        <input type="text" name="transport" size="45" value="<c:out value='${tour.tourTransport}' />">
                    </p>
                    <p>
                        <label>Nutrition</label>
                        <input type="text" name="nutrition" size="45" value="<c:out value='${tour.tourNutrition}' />">
                    </p>
                    <p>
                        <label>Duration</label>
                        <input name="duration" rows="5" size="45" value="<c:out value='${tour.tourDuration}' />">
                    </p>
                    <p>
                        <label>Price: </label>
                        <input type="text" name="price" size="45"  value="<c:out value='${tour.tourPrice}' />">
                    </p>
                    <p>
                        <input type="submit" value="Save" class="submit" />
                    </p>
            </form>
    </div>
</div>

</body>
</html>

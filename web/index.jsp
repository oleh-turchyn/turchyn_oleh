<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 6/20/2020
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <style>
        body {
            background: linear-gradient(to bottom, #72eb78, #36da95);
            font-family: 'Montserrat', sans-serif;
        }

        .block {
            width: 300px;
            height: 200px;
            margin: 100px auto 50px auto;
            padding: 20px;
            position: relative;
            border: 1px solid #fff;
            border-radius: 10px;
            background-color: #fff;
            text-align: center;
        }

        h1 {
            color: #fff;
        }

        li {
            list-style-type: none;
            margin: 10px;
        }

        ul {
            margin-left: 0;
            padding-left: 0;
        }

        a {
            font-size: 45px;
            text-decoration: none;
            color: #000;
        }

        a:hover {
            color:  #4d4a4a;
            text-decoration: underline;
        }
    </style>
</head>

<body>
<h1 align="center">Tours Managment Web Application</h1>
<div class="block">
    <ul>
        <li><a href="<%=request.getContextPath()%>/tour">Tours</a></li>
        <li><a href="<%=request.getContextPath()%>/client">Clients</a></li>
        <li><a href="<%=request.getContextPath()%>/order">Orders</a></li>
    </ul>
</div>
</body>

</html>

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
</head>
<body>
<h1>Web app </h1>
<div>
    <a href="<%=request.getContextPath()%>/tour">Tours</a>
    &nbsp;&nbsp;&nbsp;
    <button onclick="location.href='/test/tour'">List users</button>
<%--    <a href="<%=request.getContextPath()%>/list">List All Tour</a>--%>
</div>
</body>
</html>

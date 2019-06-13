<%--
  Created by IntelliJ IDEA.
  User: A754384
  Date: 2019-06-02
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${empty param.a ? "No param a" : "Param a: "} ${param.a}
    </br>
    ${empty param.b ? "No param b" : "Param b: "} ${param.b}
</body>
</html>

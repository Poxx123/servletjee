<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: A754384
  Date: 2019-06-02
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="book" items="${books}" varStatus="loop">
    Title${loop.step}: ${book.title} </br>
    Author${loop.step}: ${book.author} </br>
    ISBN${loop.step}: ${book.isbn} </br></br>
</c:forEach>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Юра
  Date: 07.12.2016
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Guest page</title>
</head>
<body>
<table>
    <tr>
        <td><h3>Новости</h3></td>
    </tr>
    <tr>
        <td><c:forEach var="news" items="${news}">
            <a href="<c:url value="/myController">
        <c:param name="selectedNewsId" value="${news.id}" />
        </c:url>">
                <c:out value="${news.newsTitle}"/>
            </a><br>
        </c:forEach></td>
    </tr>
</table>
</body>
</html>

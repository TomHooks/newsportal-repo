<%--
  Created by IntelliJ IDEA.
  User: yura
  Date: 14.05.2016
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h2>${userLogin}</h2>
<h3>Вы вошли в систему</h3>
<h4>Выберите действие:</h4>
<a href="<c:url value="/myController?command=addnewcommand"/>">Добавить новость</a><br/>
<a href="<c:url value="/myController?command=refactornew"/>">Редактировать новость</a> <br/>
<a href="<c:url value="/myController?command=addcomment"/>">Оставить комментарий</a><br/>
<a href="<c:url value="/myController?command=logout"/>">Выйти из системы</a>
<table>
    <tr>
        <td>
            <hr/>
            <h2>Список новостей</h2>
            <hr/>
        </td>
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
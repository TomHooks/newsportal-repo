<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: yura
  Date: 13.05.2016
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login"/>
    Введите ваш логин и пароль: <br/>
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" value="" size="20"/></td>
        </tr>
    </table>
    ${errorLoginOrPassword} <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type="submit" value="Войти"/>
    <a href="controller?command=gotoregistration">Регистрация</a>
</form>
<table>
    <tr>
        <td><h3>Новости</h3></td>
    </tr>
    <tr>
        <td><c:forEach var="news" items="${list}">
            <a href="<c:url value="Formalnii">
                            <c:param name="selectedNewsId" value="${news.id}" />
                        </c:url>">
                <c:out value="${news.newsTitle}"/>
            </a><br>
        </c:forEach></td>
    </tr>
</table>

</body>
</html>

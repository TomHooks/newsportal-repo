<%--
  Created by IntelliJ IDEA.
  User: yura
  Date: 15.11.2016
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<form name="loginForm" method="post" action="myController">
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
    <input type="submit" value="Войти"/>
    <a href="<c:url value="/myController?command=gotoregistration"/>">Регистрация</a>
    <a href="<c:url value="/myController?command=gotohowguest"/>">Войти как гость</a>
</form>
<%--<table>
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
</table>--%>
</body>
</html>

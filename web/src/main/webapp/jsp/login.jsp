<%--
  Created by IntelliJ IDEA.
  User: yura
  Date: 13.05.2016
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />
    Введите ваш логин и пароль: <br/>
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" value="" size="20" /></td>
        </tr>
    </table>
    ${errorLoginOrPassword} <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type="submit" value="Войти" />
    <a href="controller?command=gotoregistration">Регистрация</a>
</form>
<table>
    <tr><td><h3>Новости</h3></td></tr>
    <tr><td>Новость 1 ЗДЕСЬ ОЧЕНЬ КРУТАЯ НОВОСТЬ!!!<br/>
       Новость 2<br/>
       Новость 3<br/>
        Новость 4</td></tr>
</table>

</body>
</html>

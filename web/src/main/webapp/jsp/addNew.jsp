<%--
  Created by IntelliJ IDEA.
  User: Юра
  Date: 07.12.2016
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавить новость</title>
    <form name="addNewForm" method="post" action="myController">
        <input type="hidden" name="command" value="savenewcommand"/>
        Заполните все поля: <br/>
        <table>
            <tr>
                <td>Титульный заголовок новости:</td>
                <td><input type="text" name="title" value="" size="100"/></td>
            </tr>
            <tr>
                <td>Содержание новости:</td>
                <td><input type="text" name="content" value="" size="1000"/></td>
            </tr>
        </table>
       <br/>
        <input type="submit" value="Добавить"/>
        <a href="<c:url value="/myController?command=gotobackauthor"/>">Назад</a>

    </form>
</head>
<body>

</body>
</html>

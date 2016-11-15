<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="registrationForm" method="post" action="/MyController">
    <input type="hidden" name="command" value="registration"/>
    Введите ваши данные:<br/>
    <table>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="firstname" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><input type="text" name="lastname" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Ваша почта:</td>
            <td><input type="text" name="email" value="" size="20"/></td>
        </tr>

    </table>
    ${operationMessage}
    ${errorUserExists} <br/>
    <input type="submit" value="Зарегистрировать"/>
    <a href="controller?command=back">Вернуться обратно</a>
</form>

</body>
</html>

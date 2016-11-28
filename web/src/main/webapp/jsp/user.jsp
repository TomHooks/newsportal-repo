<%--
  Created by IntelliJ IDEA.
  User: yura
  Date: 14.05.2016
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Welcome user</title></head>
<body>
<h3>Welcome, user</h3>
<hr/>
${user}, hello!
<hr/>
Links for user...<br/>

<a href="controller?command=logout">Logout</a>

<table>
    <tr>
        <td><h3>Новости</h3></td>
    </tr>
    <tr>
        <%--<td><c:forEach var="news" items="${list}">--%>
            <%--<a href="<c:url value="Formalnii">--%>
                            <%--<c:param name="selectedNewsId" value="${news.id}" />--%>
                        <%--</c:url>">--%>
                <%--<c:out value="${news.newsTitle}"/>--%>
            <%--</a><br>--%>
        <%--</c:forEach></td>--%>
    </tr>
</table>
</body></html>
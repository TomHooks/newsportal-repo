<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yura
  Date: 16.06.2016
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${userType == USER}">

</c:if>

<h1><c:out value="${newOf.newsTitle}"/></h1><br>
<c:out value="${newOf.newsDate}"/><br>
<c:out value="${newOf.newsContent}"/>

</body>
</html>

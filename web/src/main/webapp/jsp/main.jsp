<%--
  Created by IntelliJ IDEA.
  User: yura
  Date: 14.05.2016
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Welcome admin</title></head>
<body>
<h3>Welcome, admin</h3>
<hr/>
${user}, hello!
<hr/>
Links for admin...<br/>
Debug info - session = ${sessionScope}
<a href="controller?command=logout">Logout</a>
</body></html>
<%--
  Created by IntelliJ IDEA.
  User: codeyang
  Date: 2021/11/26
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/user/checkuser" method="post">
    用户名:<input name="username" type="text">
    密码:<input type="password" name="password">
    <button type="submit">submit</button>
</form>
</body>
</html>

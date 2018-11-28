<%--
  Created by IntelliJ IDEA.
  User: ccj
  Date: 2018/11/28
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
${errorMsg}
<form action="/login" method="post">
    账号：<input name="username" type="text"/><br/>
    密码：<input name="password" type="password"/><br/>
        <input type="submit" value="登陆">
</form>
</body>
</html>

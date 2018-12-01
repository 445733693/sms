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
<%--<form action="${pageContext.request.contextPath }/login/user" method="post">--%>
<form name="form1">
    账号：<input name="username" type="text"/><br/>
    密码：<input name="password" type="password"/><br/>
        <%--<input type="submit" value="登陆">--%>
    <input type="submit" value="用户登陆" onclick="loginuser()"/>
    <input type="submit" value="代理商登陆" onclick="loginagent()"/>
    <input type="submit" value="管理员登陆" onclick="loginadmin()"/>
</form>
</body>
</html>
<script language="JavaScript">
    function loginuser() {
        document.form1.method="post";
        document.form1.action="${pageContext.request.contextPath }/login/user";
        document.forms.submit();
        console.log(document.form1.action);
        return true;
    }
    function loginagent() {
        document.form1.method="post";
        document.form1.action="${pageContext.request.contextPath }/login/agent";
        document.forms.submit();
        console.log(document.form1.action);
        return true;
    }
    function loginadmin() {
        document.form1.method="post";
        document.form1.action="${pageContext.request.contextPath }/login/admin";
        document.forms.submit();
        console.log(document.form1.action);
        return true;
    }
</script>

<%--
  Created by IntelliJ IDEA.
  User: 77039
  Date: 2019/4/26
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试参数绑定</title>
</head>
<body>

    <form action="/param/saveAccount" method="post">
        姓名：<input type="text" name="name"><br>
        金额；<input type="text" name="money"><br>
        密码；<input type="text" name="password"><br>
        <input type="submit" value="提交">

    </form>
</body>
</html>

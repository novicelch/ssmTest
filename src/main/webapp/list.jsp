<%--
  Created by IntelliJ IDEA.
  User: liuchenhu
  Date: 2020/7/30
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://shiro.apache.org/tags"  prefix="shiro"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <shiro:hasRole name="user">
        <a href="/user.jsp">用户登录</a>
        <a href="/admin.jsp">管理员登录</a>
    </shiro:hasRole>
    <shiro:hasRole name="admin">
        <a href="/admin.jsp">管理员登录</a>
    </shiro:hasRole>
    <a href="/rc/logout">退出登录</a>
</body>
</html>

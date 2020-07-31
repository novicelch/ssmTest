<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!doctype html>
<html lang="en">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="UTF-8">
    <title>企业资产管理系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script type="text/javascript"
            src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/lib/layui/layui.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="/static/js/xadmin.js"></script>
    <script type="text/javascript">
        //如果该页面在iframe中出现，那么会自动调用最外层窗口刷新本链接
        if (window != top) {
            top.location.href = location.href;
        }
    </script>

</head>
<body class="login-bg">

<div class="login">
    <div class="message">xxxx管理系统-用户登录</div>
    <font id="error" size="10" class="text-align:center" color="red"></font>
    <div id="darkbannerwrap"></div>
    <form method="post" class="layui-form">
        <input placeholder="用户名" type="text" name="rName" id="a1"
               class="layui-input">
        <hr class="hr15">
        <input placeholder="密码" type="password" name="rPassword" id="a2"
               class="layui-input">
        <hr class="hr15">
        <input lay-submit lay-filter="login" style="width: 100%;"
               type="button" value="登录" onclick="login()"/>
        <hr class="hr20">
        <div class="layui-form-item">
            <div class="layui-form-item" pane="">
                <input type="checkbox" checked="" lay-filter="filter" id="memoryuser" lay-skin="primary" title="30天内自动登录">
            </div>
        </div>
    </form>
</div>

<script>
    $(function () {
        $.ajax({
            type: "post",
            url:"rc/logout.ajax",
            dataType: "json",
            success:function (info) {
                $("#a1").val(info.rName);
                $("#a2").val(info.rPassword);
                $("#memoryuser").prop("checked","checked");
            },
            error:function () {

            }
        })
    })

    //进行登录处理
    function login() {
        var check = $("#memoryuser").prop("checked");
        var remember = "NO";
        if(check){
            remember="YES";
        }
        $.ajax({
            type: "post",
            url: "rc/checkLogin.ajax?remember="+remember,
            dataType: "text",
            data: $("form").serialize(),
            success: function (info) {
                if (info == "success") {
                    layer.msg('成功', {icon: 1});
                    window.location.href="/rc/success.do";
                } else {
                    layer.msg('账号或者密码错误！', {icon: 2});
                }
            },
            error: function () {
                layer.msg('ajax请求失败', {icon: 2});
            }
        })
    }
</script>
</body>
</html>
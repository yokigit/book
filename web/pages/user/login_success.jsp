<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--  包含base标签，css样式，jQuery文件  --%>
    <%@ include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: #1db825;
        }
    </style>
</head>
<body>
<div id="header">
    <img alt="" class="logo_img" src="static/img/logo.gif">
    <%--	静态包含登录成功后的菜单栏	--%>
    <%@include file="/pages/common/menu.jsp"%>
</div>

<div id="main">

    <h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>

</div>

<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>
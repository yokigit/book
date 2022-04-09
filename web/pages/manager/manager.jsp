<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <%--  包含base标签，css样式，jQuery文件  --%>
    <%@ include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">后台管理系统</span>
    <%--  包含管理员菜单栏  --%>
    <%@ include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>

<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>
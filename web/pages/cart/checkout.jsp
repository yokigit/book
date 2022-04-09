<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
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
    <span class="wel_word">结算</span>
    <%--	静态包含登录成功后的菜单栏	--%>
    <%@include file="/pages/common/menu.jsp" %>
</div>

<div id="main">

    <h1>你的订单已结算，订单号为2937474382928484747</h1>


</div>

<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>
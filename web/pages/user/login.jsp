<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员登录页面</title>
    <%--  包含base标签，css样式，jQuery文件  --%>
    <%@ include file="/pages/common/head.jsp" %>

</head>
<body>
<div id="login_header">
    <img alt="" class="logo_img" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                    <a href="pages/user/register.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>

                    <%--  用户名和密码错误提示 --%>
                    <c:if test="${empty requestScope.msg}">
                        <span class="errorMsg">请输入用户名和密码</span>
                    </c:if>
                    <span class="errorMsg">${requestScope.msg}</span>

                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <label>用户名称：</label>
                        <input autocomplete="off" class="itxt" name="username" placeholder="请输入用户名" tabindex="1"
                               type="text"

                               <%-- 使用empty运算判断域对象是否为空，输出响应  --%>
                               value="${empty requestScope.username?"":requestScope.username}"/>

                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input autocomplete="off" class="itxt" name="password" placeholder="请输入密码" tabindex="1"
                               type="password"/>
                        <br/>
                        <br/>

                        <input type="hidden" name="action" value="login"/>

                        <input id="sub_btn" type="submit" value="登录"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
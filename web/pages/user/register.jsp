<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>

    <%--  包含base标签，css样式，jQuery文件  --%>
    <%@ include file="/pages/common/head.jsp" %>

    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
    <script type="text/javascript">
        $(function () {

            $("#sub_btn").click(function () {
                var username = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(username)) {
                    $("span.errorMsg").text("用户名不合法");
                    $("#password").val("");
                    $("#repwd").val("");
                    $("#code").val("");
                    return false;
                }

                var password = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password)) {
                    $(".errorMsg").text("密码不合法");
                    $("#password").val("");
                    $("#repwd").val("");
                    $("#code").val("");
                    return false;
                }

                var repwd = $("#repwd").val();
                if (repwd !== password) {
                    $(".errorMsg").text("密码不一致");
                    $("#password").val("");
                    $("#repwd").val("");
                    $("#code").val("");
                    return false;
                }

                var email = $("#email").val();
                var emailPatt = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if (!emailPatt.test(email)) {
                    $(".errorMsg").text("邮箱不合法");
                    $("#password").val("");
                    $("#repwd").val("");
                    $("#code").val("");
                    return false;
                }

                var code = $("#code").val();
                if (code == null || code === "") {
                    $(".errorMsg").text("验证码不能为空");
                    return false;
                }
            })

        });
    </script>
</head>
<body>
<div id="login_header">
    <img alt="" class="logo_img" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        <%-- 错误提示 --%>
                        <c:if test="${empty requestScope.errorMsg}">

                        </c:if>
                        ${requestScope.errorMsg}
                    </span>
                </div>
                <div class="form">
                    <form action="http://localhost:8080/book/userServlet" method="post">
                        <label>用户名称：</label>
                        <input autocomplete="off" class="itxt" id="username" name="username" placeholder="请输入用户名"
                               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username") %>"
                               tabindex="1" type="text"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input autocomplete="off" class="itxt" id="password" name="password" placeholder="请输入密码"
                               value=""
                               tabindex="1" type="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input autocomplete="off" class="itxt" id="repwd" name="repwd" placeholder="确认密码"
                               value=""
                               tabindex="1" type="password"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>

                        <input autocomplete="off" class="itxt" id="email" name="email" placeholder="请输入邮箱地址"
                               value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"
                               tabindex="1" type="text"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" id="code" name="code" style="width: 150px;" type="text" value=""/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>

                        <input type="hidden" name="action" value="register"/>

                        <input id="sub_btn" type="submit" value="注册"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
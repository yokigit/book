<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--  包含base标签，css样式，jQuery文件  --%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {

            $(".updateCount").change(function () {
                const bookId = $(this).attr("bookId");
                const bookName = $(this).parent().parent().find("td:first").text();
                const count = $(this).val();
                if (confirm("确定修改《" + bookName + "》数量为" + count + "吗？")) {
                    location.href = "${basePath}cartServlet?action=updateCount&id=" + bookId + "&count=" + count;
                } else {
                    //defaultValue属性表单项Dom对象的属性，它表示默认的value属性值
                    this.value = this.defaultValue;
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>

    <%--	静态包含登录成功后的菜单栏	--%>
    <%@include file="/pages/common/menu.jsp" %>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">
                    <a href="index.jsp">当前购物车为空！快去浏览商品吧！</a>
                </td>
            </tr>
        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">

            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.value.name}</td>
                    <td>
                        <input type="text" class="updateCount" style="width:60px" bookId="${item.value.id}"
                               value="${item.value.count}">
                    </td>
                    <td>${item.value.price}</td>
                    <td>${item.value.totalPrice}</td>
                    <td><a href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
                </tr>
            </c:forEach>

        </c:if>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
        </div>
    </c:if>

</div>

<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
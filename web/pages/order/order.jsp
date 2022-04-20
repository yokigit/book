<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
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
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">我的订单</span>
    <%@ include file="/pages/common/menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>

        <c:if test="${empty requestScope.orders}">
            <tr>
                <td colspan="4">
                    <a href="index.jsp">目前还没有订单！赶紧去下单吧！</a>
                </td>
            </tr>
        </c:if>

        <c:if test="${not empty requestScope.orders}">
            <c:forEach items="${requestScope.orders}" var="order">
                <tr>
                    <td>${order.createTime}</td>
                    <td>${order.totalPrice}</td>
                    <c:choose>
                        <c:when test="${order.status==0}">
                            <td>未发货</td>
                        </c:when>
                        <c:when test="${order.status==1}">
                            <td>
                                <a href="orderServlet?action=receiveOrder&order_id=${order.id}">确认收货</a>
                            </td>
                        </c:when>
                        <c:when test="${order.status==2}">
                            <td>已签收</td>
                        </c:when>
                    </c:choose>
                    <td>
                        <a href="orderServlet?action=showOrderDetails&order_id=${order.id}">查看详情</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</div>

<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
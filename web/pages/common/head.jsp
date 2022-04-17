<%--
  Created by IntelliJ IDEA.
  User: y-CHe
  Date: 2022/4/9
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":" + request.getServerPort()
            + application.getContextPath() + "/";
    pageContext.setAttribute("basePath", basePath);
%>

<base href=${pageScope.basePath}>
<link href="static/css/style.css" rel="stylesheet" type="text/css">
<script src="static/script/jquery-1.7.2.js" type="text/javascript"></script>

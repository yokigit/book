<%--
  Created by IntelliJ IDEA.
  User: y-CHe
  Date: 2022/4/13
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>

<%-- 分页条 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">

    <c:if test="${requestScope.bookPage.pageNo>1}">
        <a href="${requestScope.bookPage.url}&pageNo=1">首页</a>
        <a href="${requestScope.bookPage.url}&pageNo=${requestScope.bookPage.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>

        <c:when test="${requestScope.bookPage.pageTotal<=5}">
            <c:forEach begin="1" end="${requestScope.bookPage.pageTotal}" var="i">
                <c:if test="${i==requestScope.bookPage.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i!=requestScope.bookPage.pageNo}">
                    <a href="${requestScope.bookPage.url}&pageNo=${i}">${i} </a>
                </c:if>
            </c:forEach>
        </c:when>

        <c:when test="${requestScope.bookPage.pageTotal>5}">
            <c:choose>

                <c:when test="${requestScope.bookPage.pageNo<=3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i==requestScope.bookPage.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.bookPage.pageNo}">
                            <a href="${requestScope.bookPage.url}&pageNo=${i}">${i} </a>
                        </c:if>
                    </c:forEach>
                </c:when>

                <c:when test="${requestScope.bookPage.pageNo>requestScope.bookPage.pageTotal-3}">
                    <c:forEach begin="${requestScope.bookPage.pageTotal-4}" end="${requestScope.bookPage.pageTotal}"
                               var="i">
                        <c:if test="${i==requestScope.bookPage.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.bookPage.pageNo}">
                            <a href="${requestScope.bookPage.url}&pageNo=${i}">${i} </a>
                        </c:if>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <c:forEach begin="${requestScope.bookPage.pageNo-2}" end="${requestScope.bookPage.pageNo+2}"
                               var="i">
                        <c:if test="${i==requestScope.bookPage.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.bookPage.pageNo}">
                            <a href="${requestScope.bookPage.url}&pageNo=${i}">${i} </a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>

            </c:choose>
        </c:when>

    </c:choose>
    <c:if test="${requestScope.bookPage.pageNo<requestScope.bookPage.pageTotal}">
        <a href="${requestScope.bookPage.url}&pageNo=${requestScope.bookPage.pageNo+1}">下一页</a>
        <a href="${requestScope.bookPage.url}&pageNo=${requestScope.bookPage.pageTotal}">末页</a>
    </c:if>

    共${requestScope.bookPage.pageTotal}页，${requestScope.bookPage.pageTotalCount}条记录
    到第<input type="text" value="${param.pageNo}" name="pn" id="pageNo_input" style="width: 20px"/>页
    <input type="button" id="searchPageBtn" value="确定">

    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pageNo_input").val();
                //判断输入页码是否为整数
                if (!Number.isInteger(pageNo)) {
                    alert("输入页码类型有误");
                    return false;
                }
                if (pageNo < 1 || pageNo >${requestScope.bookPage.pageTotal}) {
                    alert("输入页码越界");
                    return false;
                }
                location.href = "${pageContext.request.scheme}" + "://"
                    + "${pageContext.request.serverName}" + ":"
                    + "${pageContext.request.serverPort}"
                    + "${pageContext.request.contextPath}"
                    + "/${requestScope.bookPage.url}&pageNo=" + pageNo;
                // location.href = "http://localhost:8080//book/${requestScope.bookPage.url}&pageNo=" + pageNo;
            })
        });
    </script>
</div>

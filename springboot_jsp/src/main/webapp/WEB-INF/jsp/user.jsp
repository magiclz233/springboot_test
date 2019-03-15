<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: luozhang
  Date: 2019/3/15
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<p>日期<%=new Date()%></p>
<hr>
<p>
    多行代码
    <%
    out.println(request.getRemoteAddr());
    out.print( "magiclz233" );
    %>
</p>
<c:if test="${username != null}">
    用户名为${username}
</c:if>

<h3>for循环</h3>
<%
int count = (int) session.getAttribute( "count" );
for (int i =0;i<count;i++){
%>
纯洁的微笑<%
System.out.println(i);
    }
%>

<h3>c:choose</h3>
<c:choose>
    <c:when test="${age >= 120}">
        age > 120
    </c:when>
    <c:when test="${0< age}">
        0 < age
    </c:when>
    <c:otherwise>
        age <= 0
    </c:otherwise>
</c:choose>
<%@include file="footer.jsp"%>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>用来展示所有用户信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    <script>
        $(function () {
            alert();
        })
    </script>
</head>
<body>

<h1>展示用户列表</h1>
<c:forEach items="${requestScope.users}" var="user">
    ${user.id} === ${user.name} === ${user.age} === ${user.bir}<br>
</c:forEach>

<a href="${pageContext.request.contextPath}/add.jsp">添加用户信息</a>
</body>
</html>

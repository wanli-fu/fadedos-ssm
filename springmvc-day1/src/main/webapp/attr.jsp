<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>测试数据传递</title>
</head>
<body>

<h1>测试request数据传递</h1>
<h3>获取request作用域数据:${requestScope.username}</h3>
<h3>获取request作用域数据:${username}</h3>
<hr color="red">
<h3>id:${requestScope.user.id}</h3>
<h3>name:${requestScope.user.name}</h3>
<h3>age:${requestScope.user.age}</h3>
<h3>bir: <fmt:formatDate value="${requestScope.user.bir}" pattern="yyyy-MM-dd"/> </h3>
<hr color="red">
<c:forEach items="${requestScope.users}" var="user">
    id:${user.id} === ${user.name} === ${user.age}  ==== <fmt:formatDate value="${user.bir}"/><br>
</c:forEach>

<hr color="green">
<h3>获取地址栏数据:${param.name}</h3>
<hr color="green">
<h3>获取session作用域中 id:${sessionScope.user.id}</h3>
<h3>获取session作用域中 name:${sessionScope.user.name}</h3>
<h3>获取session作用域中 age:${sessionScope.user.age}</h3>
<h3>获取session作用域中 bir:${sessionScope.user.bir}</h3>
</body>
</html>

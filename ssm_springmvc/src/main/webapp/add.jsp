<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>添加用户信息</title>
</head>
<body>

<h1>添加用户信息</h1>
<form action="${pageContext.request.contextPath}/user/save" method="post">
    用户name: <input type="text" name="name"><br>
    用户age: <input type="text" name="age"><br>
    用户bir: <input type="text" name="bir"><br>
    <input type="submit" value="保存用户信息"/>
</form>
</body>
</html>

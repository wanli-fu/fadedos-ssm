<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>测试参数接收</title>
</head>
<body>

<h1>测试对象和零散类型参数接收</h1>
<form action="${pageContext.request.contextPath}/param/test2" method="post">
    用户id: <input type="text" name="id"><br>
    用户name: <input type="text" name="name"><br>
    用户age: <input type="text" name="age"><br>
    用户bir: <input type="text" name="bir"><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <form method="post" action="${pageContext.request.contextPath}/reg.action">
        UserName<input type="text" name="user.name"/><br/>
        password<input type="password" name="user.password"/><br/>
        <input type="submit" value="reg"/>
    </form>
</body>
</html>

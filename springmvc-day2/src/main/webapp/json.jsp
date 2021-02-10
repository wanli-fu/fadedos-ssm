<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>测试spring mvc与ajax集成</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script>
    $(function () {
     $("#btn").click(function () {
         $.get("${pageContext.request.contextPath}/json/showAll",function (res) {
             console.log(res)
         },"json")
     })
    })
</script>
<body>

<button id="btn">显示一群人</button>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>测试文件上传和下载</title>
</head>
<body>

<h1>文件上传</h1>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>

    <input type="submit" value="上传文件 "/>
</form>

<h1>文件下载</h1>
<ul>
    <li>
        aa.txt <a href="${pageContext.request.contextPath}/file/download/?fileName=aa.txt">在线打开</a>
        <a href="${pageContext.request.contextPath}/file/download/?fileName=aa.txt&openStyle=attch">附件下载</a>
    </li>
    <li>
        微信图片_20210114002943 <a href="${pageContext.request.contextPath}/file/download/?fileName=微信图片_20210114002943.jpg">在线打开</a>
        <a href="${pageContext.request.contextPath}/file/download/?fileName=微信图片_20210114002943.jpg&openStyle=attch">附件下载</a>
    </li>
    <li>
        aa.txt <a href="${pageContext.request.contextPath}/file/download/?fileName=aa.txt">在线打开</a>
        <a href="${pageContext.request.contextPath}/file/download/?fileName=aa.txt&openStyle=attch">附件下载</a>
    </li>
</ul>

</body>
</html>

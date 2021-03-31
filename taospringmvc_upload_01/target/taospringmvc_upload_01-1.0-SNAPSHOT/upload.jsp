<%--
  Created by IntelliJ IDEA.
  User: Long
  Date: 2021/3/27
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传页面</title>
</head>
<body>
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        图片：<input type="file" name="upload"><br/>
        图片描述：<input type="text" name="pdesc">
        <input type="submit" value="上传">
    </form>
</body>
</html>

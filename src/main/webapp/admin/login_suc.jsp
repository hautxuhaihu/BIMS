<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xuhaihu
  Date: 19-4-19
  Time: 下午3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
    <meta name="viewport" content="width=device-width, height=device-height">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.0/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div id="nav" class="col-md-2"></div>
        <script>
            $("#nav").load("html/adminNav.html");
        </script>

        <div class="col-md-10">
            恭喜您登陆成功<br>
            您的账号:<br>
            <s:property value="#session['usersession']['id']"/><br>
        </div>
    </div>
</div>
</body>
</html>

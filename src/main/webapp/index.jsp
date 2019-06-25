<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xuhaihu
  Date: 19-6-24
  Time: 上午10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>我的bootstrap</title>
  <meta name="viewport" content="width=device-width, height=device-height">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.0/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.0/js/bootstrap.min.js"></script>
  <style>
    .row{
      height:20%;
    }
    .btn-right{
      float: right;
    }

  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row">
  </div>
  <div class="row">
    <div class="col-md-4">
    </div>
    <div class="col-md-4">
      <div align="center">
        <h3>登录界面</h3>
      </div>
      <s:form role="form" action="loginCheck">
        <div class="form-group">
          <label for="exampleInputUsername">
            用户名
          </label>
          <input type="text" name="username" class="form-control" id="exampleInputUsername"/>
        </div>
        <div class="form-group">

          <label for="exampleInputPassword">
            密码
          </label>
          <input type="password" name="password" class="form-control" id="exampleInputPassword" />
        </div>
        <div>
          <button type="submit" class="btn btn-primary btn-block">
            提 交
          </button>
          <button type="reset" class="btn btn-danger btn-right btn-block">
            重 置
          </button>
        </div>
      </s:form>
    </div>
  </div>
</div>
</body>
</html>


<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xuhaihu
  Date: 19-6-26
  Time: 上午8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍分类</title>
</head>
<body>
<s:form name="addType" action="addType">
    <s:textfield name="name" label="书籍类别" requiredLabel="true"/>
    <s:submit/>
</s:form>
</body>
</body>
</html>

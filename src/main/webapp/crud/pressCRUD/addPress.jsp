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
    <title>添加出版社</title>
</head>
<body>
添加出版社<br>
<s:form name="addPress" action="addPress">
    <s:textfield name="name" label="出版社" requiredLabel="true"/>
    <s:submit/>
</s:form>
</body>
</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xuhaihu
  Date: 19-6-29
  Time: 下午7:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询图书</title>
    <s:head/>
    <sj:head/>
</head>
<body>
<%--<s:url var="queryAllPressUrl" action="queryAllPress"/>--%>
<%--<s:url var="queryAllTypeUrl" action="queryAllType"/>--%>
<s:form name="queryBook" action="queryBook">
    <s:textfield name="isbn" label="ISBN"/>
    <s:textfield name="name" label="书名"/>
    <s:textfield name="author" label="作者"/>
<%--    <s:select name="OP" label="选择查询类型" list="{'isbn','name','author'}"/>--%>
    <s:submit/>
</s:form>
</body>
</html>

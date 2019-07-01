<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="a" uri="/struts-jquery-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xuhaihu
  Date: 19-6-27
  Time: 上午9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
    <s:head/>
    <sj:head/>
</head>
<body>
<s:url var="queryAllPressUrl" action="queryAllPress"/>
<s:url var="queryAllTypeUrl" action="queryAllType"/>
<s:form name="addBook" action="addBook" enctype="multipart/form-data">
    <s:textfield name="isbn" label="ISBN" requiredLabel="true"/>
    <s:textfield name="name" label="书名" requiredLabel="true"/>
    <s:textfield name="author" label="作者" requiredLabel="true"/>
    <s:textfield name="price" label="价格" requiredLabel="true"/>
<%--    <s:textfield name="date" label="日期" type="date" value="%{getText('format.date',{date})}"/>--%>
    <s:textfield name="date" label="日期" type="date" />
    <sj:select id="press" name="press" label="出版社" href="%{queryAllPressUrl}"
               list="allPress" listKey="name" listValue="name" headerKey="-1" headerValue="please select"/>
    <sj:select id="type" name="type" label="书籍类型" href="%{queryAllTypeUrl}"
               list="allType" listKey="name" listValue="name" headerKey="-1" headerValue="please select"/>
    <s:file name="myUpload" label="选择封面"/>
    <s:submit/>
</s:form>
</body>
</html>

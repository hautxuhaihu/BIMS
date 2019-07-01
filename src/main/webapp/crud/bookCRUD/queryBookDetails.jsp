<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xuhaihu
  Date: 19-6-30
  Time: 下午5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <s:head/>
    <sj:head/>
</head>
<body>
<table>
    <tr><td>ISBN<td>书名<td>作者<td>出版社<td>分类<td>出版时间<td>价格<td>封面<td>平均评分</tr>
    <tr>
        <td><s:property value="book.isbn"/>
        <td><s:property value="book.name"/>
        <td><s:property value="book.author"/>
        <td><s:property value="book.press"/>
        <td><s:property value="book.type"/>
        <td><s:property value="book.date"/>
        <td><s:property value="book.price"/>
        <td><img src="${pageContext.request.contextPath}/<s:property value="book.cover"/>" width="255"/>
        <td><s:property value="book.avgScore"/>

    </tr>
</table>

<%--<s:url var="queryScoreUrl" action="queryScore">--%>
<%--    <s:param name="isbn" value="book.isbn"/>--%>
<%--</s:url>--%>
<%--<sj:div id="scoreDiv" href="%{queryScoreUrl}"/>--%>


<%--<s:url var="queryAllPressUrl" action="queryAllPress"/>--%>

<s:action name="queryAllPress" executeResult="false" var="findPress"/>
<sj:div id="accordion1"
              list="#findPress.allPress" listValue="name"
              heightStyle="content"
              active="false"
              openOnMouseover="true"
              collapsible="true"
/>
<%--<sj:accordion id="accordion1" href="%{queryAllPressUrl}"--%>
<%--              list="allPress" listKey="name" listValue="name"--%>
<%--/>--%>
<%--单击加载--%>
<%--<sj:div id="loadAfterClick" href="%{queryAllPressUrl}" deferredLoading="true" reloadTopics="reloadStuList"/>--%>
<%--<sj:a id="reloadBtn" onClickTopics="reloadStuList" button="true">reloadStuList</sj:a>--%>

<s:form name="addScore" action="addScore">
    <s:hidden name="isbn" value="%{book.isbn}"/>
    <s:select name="score" label="我的评分" list="{1,2,3,4,5}" requiredLabel="true"/>
    <s:submit value="保存"/>
</s:form>
<%--<s:form name="addComment" action="addComment">--%>
<%--    <s:textarea name="comment" label="我的评论" requiredLabel="true"/>--%>
<%--    <s:submit value="保存"/>--%>
<%--</s:form>--%>
<table>
    <tr><td>评价</td></tr>
    <tr>
        <s:iterator value="allComment" var="row" status="status">
            <td><s:property value="#row.comment"/>
        </s:iterator>
    </tr>
</table>

</body>
</html>

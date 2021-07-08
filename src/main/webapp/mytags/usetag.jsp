<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://my.scwcd" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:required /><p/>
            <my:greet /><p/>
            <my:greet user="Yun" /><p/>
            <my:greet user="Yun ${1+2}"/><p/>
            <%--new Date().getTime()現在微秒數--%>
            <my:if condition="<%=new Date().getTime() % 2 == 0%>">
                現在時間:<%=new Date()%>
            </my:if><p/>
            <my:loop count="3" >
                java
            </my:loop><p/>
        </h1>
        <hr>
        <my:mark search="se">
            she sell sea shore on the sea shore
        </my:mark>
        <hr>
        <h1>
            <my:implicit attributeName="authCode" scopeName="session" /><p/>
        </h1>
        <my:switch conditionValue="1">
            <my:case caseValue="1">男生</my:case>
            <my:case caseValue="2">女生</my:case>
            <my:default>錯誤</my:default>
        </my:switch>

    </body>
</html>

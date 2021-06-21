<%-- 
    Document   : calcAreaResult
    Created on : 2021/6/9, 下午 07:49:45
    Author     : NO NAME
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--讓程式無法由Client端直接進行存取　將calcAreaResult.jsp放入WEB-INF下-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>計算結果</title>
        <!--套用 https://purecss.io css-->
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <!--上下左右留白20px-->
    <body style="padding: 20px">
        <% List<Map> list = (List) request.getAttribute("list");%>
        <%for (Map map : list) {%>
        <% if(map.get("r").toString().equals("0")) continue;%>
        <form class="pure-form" >
            <fieldset>
                <legend style="color: #005100">計算<%=map.get("name")%>結果</legend>
                半徑:<font color="#0000ff"><%=map.get("r")%></font><br \><!--折行可以放很多個-->
                結果:<font color="#ff0000"><%=map.get("result")%></font><p \><!--換行放很多沒效果-->
                <button type="button" onclick="window.history.back()" class="pure-button pure-button-primary">回上一頁</button>
            </fieldset>
        </form>
        <% }%>        
    </body>
</html>

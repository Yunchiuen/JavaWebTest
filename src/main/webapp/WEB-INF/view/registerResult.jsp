<%-- 
    Document   : calcAreaResult
    Created on : 2021/6/9, 下午 07:49:45
    Author     : NO NAME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--讓程式無法由Client端直接進行存取　將calcAreaResult.jsp放入WEB-INF下-->
<%
    String sno = request.getAttribute("sno").toString();
    String eno = request.getAttribute("eno").toString();
    String times = request.getAttribute("times").toString();
    Boolean pay = Boolean.parseBoolean(request.getAttribute("pay").toString());
    String memo = request.getAttribute("memo").toString();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>註冊結果</title>
        <!--套用 https://purecss.io css-->
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <!--上下左右留白20px-->
    <body style="padding: 20px">
        <form class="pure-form" >
            <fieldset>
                <legend style="color: #005100">註冊結果</legend>
                學員編號:<%= sno%><p />
                認證代號:<%= eno%><p />
                考試時段:<%= times%><p />
                繳費狀況:<%= pay ? "已繳" : "未繳"%><p />
                備註資料:<%= memo%><p />
                <button type="button" onclick="window.history.back()" class="pure-button pure-button-primary">回上一頁</button>
            </fieldset>
        </form>
    </body>
</html>

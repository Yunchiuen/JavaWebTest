<%-- 
    Document   : bmiResult
    Created on : 2021/6/14, 上午 09:55:17
    Author     : NO NAME
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--線上icon製作-->
        <!--http://tw.faviconico.org/favicon-->
        <link rel="icon" href="../icons/bmi.ico" type="image/x-icon" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
        <title>計算結果</title>
    </head>
    <body style="padding: 20px">
        <% List<Map> list = (List) request.getAttribute("list");%>
        <% for (Map map : list) {%>
        <% if (map.get("height").toString().equals("0.0"))continue;%>
        <% if (map.get("weight").toString().equals("0.0"))continue;%>
        <form class="pure-form" >
            <fieldset>
                <legend>(BMI)計算結果</legend>
                身高:<font color="#0000ff"><%=map.get("height")%></font> <p />
                體重:<font color="#0000ff"><%=map.get("weight")%></font> <p />
                結果:<font color="#ff0000"><%=map.get("result")%></font> <p />
            </fieldset>
            <%}%>    
            <button type="button" onclick="window.history.back()" class="pure-button pure-button-primary">回上一頁</button>
        </form>
    </body>
</html>

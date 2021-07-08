<%@page import="java.util.Random" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- html註解 -->
<%--
<%@ %>    會優先運做 

<% %>       scriptlet 配置在_jspService()內

<%=1 + 1%>  expression 配置在_jspService()內 ex:<% out.print(1+1) %>;
            expression 結尾不可有分號<%=x;%>
            expression =不可出現2次含以上
            expression 不可放沒有傳回值的方法

<%! %>      宣告區declare 物件變數,方法 配置在_jspService()外

--%>
<%int x = 100;%>
<%!int x = 200;%>

<%=++x%>
<%=this.x%>

<%=getLotto()%>
<%
    out.print(getLotto());
%>
<%--方法內不能有方法所以要加上!方法就會放在class下--%>
<%!

    int getLotto() {
        return new Random().nextInt(100);
    }
%>


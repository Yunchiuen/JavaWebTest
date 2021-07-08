<%-- <%@page import%>會先運做 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.web.job.Lotto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--
    html與jsp差異
    html是tomcat直接將html文字丟給瀏覽器不做任何修正
    html是死的無法動態
    jsp的話會變成servlet程式最後會產生html文字給前端
    jsp就是將死的變成可以動態的元素
    jsp就是servlet
    hello.jsp -> hello_jsp.java 編譯-> hello_jsp.class
--%>
<%
    Lotto lotto = new Lotto();
    List list = new ArrayList(lotto.get539());

    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
    </head>
    <body style="padding: 20px">
        <h1>
            <%
                out.print(list);
            %>
        </h1>
        <!-- include file="hello2.jsp?id=1" include不可代參數 -->
        <%@include file="hello2.jsp" %>
        
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>1</th><th>2</th><th>3</th><th>4</th><th>5</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=list.get(0)%></td>
                    <td><%=list.get(1)%></td>
                    <td><%=list.get(2)%></td>
                    <td><%=list.get(3)%></td>
                    <td><%=list.get(4)%></td>
                </tr>  
            </tbody>

        </table>

        <%
            //out可以用是因為jsp的隱含變數
            //隱含變數不用宣告就可使用
            //htnl這些全部都會放在
            //_jspServicefinal(HttpServletRequest request, HttpServletResponse response)
            out.print(sdf.format(now));
        %>
    </body>
</html>

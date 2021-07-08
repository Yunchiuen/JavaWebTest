<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>

            <%String message = "I_love_java中文";%>
            <%--
                靜態include無法代參數
                把title.jsp的原始碼複製到main.jsp
                在跟main程式碼一起編譯
                所以title.jsp可以呼叫到<%=message%> 
            --%>
            <%@include file="title.jsp" %>
        </h1>
        <hr>
        <h1>
            <%--
                動態include可以代參數
                我先編譯執行到include
                在去執行你執行的結果
                把你的執行結果給我
                我才會繼續往下執行
                所以在salary.jsp無法呼叫<%=message%>
            --%>
            <!--動態include代參數-->
            <jsp:include page="salary.jsp?salary=10&salary=20" >
                <jsp:param name="message" value="<%=message%>" />
                <jsp:param name="salary" value="40000" />
                <jsp:param name="salary" value="50000" />
            </jsp:include>
        </h1>
        <h1>
            ${header["User-Agent"] }
        </h1>
    </body>
</html>

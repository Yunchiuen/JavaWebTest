<%@page import="com.web.job.Calc"%>
<%-- session預設是有宣告隱含變數,不要有改false即可 --%>
<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    
    <%
        Calc calc=new Calc();
        calc.setX(10);
        calc.setY(20);
        out.print(calc.getResult());
    %>  
    
    <jsp:useBean id="calc2" class="com.web.job.Calc" />
    <jsp:setProperty name="calc2" property="x" value="20" />
    <jsp:setProperty name="calc2" property="y" value="50" />
    <jsp:getProperty name="calc2" property="result" />
    
</html>

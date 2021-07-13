<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="http://taiwan/TLDTest/WEB-INF/tlds/mytld"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:welcome username="Yun" >
                現在時刻:<%=new Date()%>$
            </my:welcome>
        </h1>
    </body>
</html>

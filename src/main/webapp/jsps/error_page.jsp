<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>
            <%-- 宣告isErrorPage 才可以使用exception --%>
            <%= exception.getMessage()%>
        </h1>
    </body>
</html>

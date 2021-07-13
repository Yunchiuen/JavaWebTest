<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="http://taiwan/TLDTest/WEB-INF/tlds/mytld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:bmi h="170" w="60"/><p />
            <my:bmi h="150" w="70" result="true" /><p />
            <my:bmi h="180" w="60" result="false" /><p />
            <my:bmi h="180" w="50" result="" /><p />
        </h1>
    </body>
</html>

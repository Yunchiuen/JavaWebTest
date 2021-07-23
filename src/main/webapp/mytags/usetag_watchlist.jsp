<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Watch List</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
    </head>
    <body style="padding: 15px">
        
        <my:watchlist symbols="${param.symbols}" /><%-- ${param.symbol} 代?號參數--%>

    </body>
</html>

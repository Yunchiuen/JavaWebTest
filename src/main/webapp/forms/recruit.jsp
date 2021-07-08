<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>招聘</title>
        <meta charset="UTF-8">
        <!--線上icon製作-->
        <!--http://tw.faviconico.org/favicon-->
        <link rel="icon" href="../icons/favicon.ico" type="image/x-icon" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--套用 https://purecss.io css -->
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <!--上下左右留白20px-->
    <body style="padding: 20px">
        <!--表單送到這裡 action="/JavaWebTest/controller/CalcArea" 不一定要跟Servler名稱一樣而是按照urlPatterns-->
        <form class="pure-form" method="post" action="/JavaWebTest/controller/recruit">
            <fieldset>
                <legend>招聘</legend> 
                <img src="../images/person.png" width="40" valign="middle" />
                <input type="number" placeholder="請輸入人數" name="amount"/>
                <button type="submit" class="pure-button pure-button-primary">submit</button>
            </fieldset>
        </form>
    </body>
</html>


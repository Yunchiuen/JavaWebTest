<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--因為jsp裡面預設會有session變數,那邊session變數就已經進立連線,我這邊先不需要 --%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI(Session版)</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
    </head>
    <body style="padding: 20px">
        <form class="pure-form" method="post" action="/JavaWebTest/controller/bmi_session">
            <fieldset>
                <legend>BMI(Session版) 使用人數 : ${applicationScope.count} 人</legend>
                <input type="text" placeholder="請輸入姓名" name="cname" value="Yun" /><p />
                <input type="text" placeholder="請輸入身高" name="height" value="180"/><p />
                <input type="text" placeholder="請輸入體重" name="weight" value="60"/><p />
                <input type="text" placeholder="請輸入驗證碼" name="code" />
                <img src="/JavaWebTest/controller/authcode" valign="middle" /><p />
                <button type="submit" class="pure-button pure-button-primary">傳送</button>
                <!-- onclick="location.href = '/JavaWebTest/controller/bmi_session'" 這是get-->
                <button type="button" 
                        onclick="location.href = '/JavaWebTest/controller/bmi_session'" 
                        class="pure-button pure-button-primary" >檢視</button>
                <button type="button" 
                        onclick="location.href = '/JavaWebTest/controller/bmi_session_invalid'" 
                        class="pure-button pure-button-primary" >刪除Session</button>
                <p/>
                
            </fieldset>
        </form>
    </body>
</html>

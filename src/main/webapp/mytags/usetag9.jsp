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
            原報告：<br>
            今日研究報告:台積電將在大陸設晶圓廠 ...
        </h1>
        <hr>
        <h1>
            加值報告：<br> <!--  △ ▽ -->
<!--            今日研究報告:台積電<font color='gray'>(2330.TW <font color='#005100'>$585.00 ▽4</font>   <input type='button' value='下單' />)</font>將在大陸設晶圓廠 ...-->
            今日研究報告:台積電<my:report symbol="2330.TW" > </my:report>將在大陸設晶圓廠 ...
        </h1>
        <h1>
            今日研究報告:蘋果<my:report symbol="AAPL" > </my:report>
        「iPhone 12 系列目前銷量迫人；而在一年一度的新機發布會前，7至9月的銷量慣例上都表現超卓；以及在投資者預期降低的情况下，
        iPhone 13銷量有機會錄得超乎想像的表現；這些因素意味蘋果股份在下半年非常有吸引力，我們並預期它將在下半年大幅跑贏大市。」
        </h1>

    </body>
</html>

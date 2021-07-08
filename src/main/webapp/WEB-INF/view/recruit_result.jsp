<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>招聘結果</title>
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
        <form class="pure-form">
            <fieldset>
                <legend>招聘結果</legend> 
                總人數 : ${fn:length(list)}<p/>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Sex</th>
                            <th>Score</th>
                            <th>Pass</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${list}" varStatus="item" >
                            <tr>
                                <td>${item.index+1 }</td>
                                <td>${p.name }</td>
                                <td>${p.sex }</td>
                                <td>${p.score }</td>
                                <td>
                                    <c:if test="${p.score >=60}" >
                                        <c:set var="i" value="${i+1}" />
                                        <c:out value="Pass" />
                                    </c:if>
                                </td>
                            </tr>   
                        </c:forEach>
                    </tbody>
                </table>
               
                錄取人數 : ${i}
                <p/>
                <button type="button" onclick="window.history.back()" class="pure-button pure-button-primary">回上一頁</button>
            </fieldset>
        </form>
    </body>
</html>


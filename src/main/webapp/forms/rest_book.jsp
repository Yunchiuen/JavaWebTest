<%@page import="com.web.rest.bookstore.BookDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--套用 https://purecss.io css -->
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <!--java script語法-->
        <!--
            解決代太多參數辦法 
            function updateBook(book) {
                document.getElementById('uId').value = id;
                document.getElementById('uName').value = name;
                document.getElementById('uPrice').value = price;
            }
            
        -->
        <script>
            // 較新的瀏覽器中已經有提供btoa和atob兩個全域函式，可以用來做base64的encode和decode
            function updateBook(base64str) {
                //base64
                console.log(base64str);
                //將json字串變成json物件
                console.log(atou(base64str));
                var jsonStr = atou(base64str);
                var book = JSON.parse(jsonStr);
                document.getElementById('uId').value = book.id;
                document.getElementById('uName').value = book.name;
                document.getElementById('uPrice').value = book.price;
            }
            function deleteBook(id) {
                document.getElementById('dId').value = id;
            }
            //因為atob不支援中文
            //使用utf-8進行解析base64
            function atou(str) {
                return decodeURIComponent(escape(window.atob(str)));
            }
            // 使用 utf-8 進行編碼 base64
            function utoa(str) {
                return window.btoa(unescape(encodeURIComponent(str)));
            }

        </script>
    </head>
    <!--上下左右留白20px-->
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Rest Book List</legend> 
                <table class="pure-table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>price</th>
                            <th>修改</th>
                            <th>刪除</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="book" items="${ BookDao.books }">
                            <tr>
                                <td>${ book.id }</td>
                                <td>${ book.name }</td>
                                <td>${ book.price }</td>
                                <!--onclick="updateBook(${ book.id }, '${ book.name }',${ book.price })" 
                                    解決代太多參數辦法
                                    這樣做是沒有辦法分析要變成json格式,再變成base64編碼
                                    base64就是一串字串
                                    丟進去要變成base64編碼到了java script再還原base64編碼編碼前的樣子
                                -->
                                <td>
                                    <button type="button" 
                                            onclick="updateBook('${ book }')"
                                            class="pure-button pure-button-primary">修改</button>
                                </td>
                                <td>
                                    <button type="button"
                                            onclick="deleteBook(${ book.id })"
                                            class="pure-button pure-button-primary">刪除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </fieldset>
        </form>
        <table>
            <!--新增-->
            <td valign="top">
                <form class="pure-form" method="post" action="/JavaWebTest/rest/book">
                    <fieldset>
                        <legend>Rest Book POST</legend> 
                        <input name="id" placeholder="id" /><p />
                        <input name="name" placeholder="名稱" /><p />
                        <input name="price" placeholder="價格" /> <p />
                        <button type="submit" class="pure-button pure-button-primary">新增</button>
                    </fieldset>
                </form>
            </td>
            <!--修改-->
            <td valign="top">
                <form class="pure-form" method="post" action="/JavaWebTest/rest/book">
                    <fieldset>
                        <legend>Rest Book PUT</legend> 
                        <!--必須要加這個欄位這樣表單會有傳put或delete假象-->
                        <input name="_method" type="hidden" value="PUT" />
                        <!--readonly無法修改-->
                        <input id="uId" name="id" placeholder="id" readonly /><p />
                        <input id="uName" name="name" placeholder="名稱" /><p />
                        <input id="uPrice" name="price" placeholder="價格" /> <p />
                        <button type="submit" class="pure-button pure-button-primary">修改</button>
                    </fieldset>
                </form>
            </td>
            <!--刪除-->
            <td valign="top" >
                <form class="pure-form" method="post" action="/JavaWebTest/rest/book">
                    <fieldset>
                        <legend>Rest Book DELETE</legend> 
                        <!--必須要加這個欄位這樣表單會有傳put或delete假象-->
                        <input name="_method" type="hidden" value="DELETE" />
                        <!--readonly無法修改-->
                        <input id="dId" name="id" placeholder="id" readonly/><p />
                        <button type="submit" class="pure-button pure-button-primary">刪除</button>
                    </fieldset>
                </form>
            </td>
        </table>    
    </body>
</html>


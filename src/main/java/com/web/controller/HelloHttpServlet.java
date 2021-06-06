package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
    Client請求URL http://localhost:8080/JavaWebTest/hello?name=john
    /JavaWebTest -> context path 要到META-INF/context.xml中設定與配置
    /hello       -> url-pattern  要到WEB-INF/web.xml中設定與配置
*/
public class HelloHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req表示收到client端的請求資訊 
        String name = req.getParameter("name");

        //res表示要回應給client端的內容
        PrintWriter out = resp.getWriter();//透過out可以將訊息回傳給client
        out.print("Hello:");//把訊息寫在HTTP Response 文件的Part4
        out.print(name);
        out.print(" "+new Date());
    }

}

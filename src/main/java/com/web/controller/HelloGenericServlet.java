package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
    Client請求URL http://localhost:8080/JavaWebTest/hi?name=john
    /JavaWebTest -> context path 要到META-INF/context.xml中設定與配置
    /hi          -> url-pattern  要到WEB-INF/web.xml中設定與配置
*/
public class HelloGenericServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //req表示收到client端的請求資訊 
        String name = req.getParameter("name");

        //res表示要回應給client端的內容
        PrintWriter out = res.getWriter();//透過out可以將訊息回傳給client
        out.print("Hi:");//把訊息寫在HTTP Response 文件的Part4
        out.print(name);
        out.print(" "+new Date());
        
    }

}

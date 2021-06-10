package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/JavaWebTest/HelloNewServlet
//http://localhost:8080/JavaWebTest/aaa/bbb/ccc
//http://localhost:8080/JavaWebTest/hello.asp
//http://localhost:8080/JavaWebTest/anyword/任意字串
//利用 @ 配置Servlet
@WebServlet(name = "HelloNewServlet",
            urlPatterns = {"/HelloNewServlet","/aaa/bbb/ccc","/hello.asp","/anyword/*"})
public class HelloNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("HelloNewServlet " + new Date());
    }

}

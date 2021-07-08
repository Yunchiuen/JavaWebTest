package com.web.controller.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/cookies/write")
public class WriteCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salary = req.getParameter("salary");
        String age = req.getParameter("age");
        
        //建立Cookies
        Cookie cookieSalary = new Cookie("salary", salary + "");
        Cookie cookieAge = new Cookie("age", age + "");
        
        //設定續存時間(秒)
        //沒有設定預設30分
        cookieSalary.setMaxAge(15);
        cookieAge.setMaxAge(15);
        
        //將Cookies 寫入Client端
        resp.addCookie(cookieSalary);
        resp.addCookie(cookieAge);
        
        resp.getWriter().print("Write Cookies ok");
    }

}

package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controller/bmi_session")
public class BMISessionSevlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 表單送過來需要建立建立Sessionid  
        HttpSession session = req.getSession();
        // 設定session續存時間(秒)  以程式設定為主,沒有設定以web.xml為主
        //session.setMaxInactiveInterval(10);
        
        String cname = req.getParameter("cname");
        //double 前面宣告大小寫沒差
        double height = Double.parseDouble(req.getParameter("height"));
        Double weight = Double.parseDouble(req.getParameter("weight"));
        Double bmi = weight / Math.pow(height / 100, 2);
        //將資料存入session
        session.setAttribute("cname", cname);
        session.setAttribute("height", height);
        session.setAttribute("weight", weight);
        session.setAttribute("bmi", bmi);
        
        PrintWriter out = resp.getWriter();
        out.println("Post ok"+"<br/>");
        out.println("session id:"+session.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //檢視不要建立Sessionid 
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        out.println("Get ok"+"<br/>");
        out.println("session id : "+session.getId()+"<br/>");
        out.println("cname : "+session.getAttribute("cname")+"<br/>");
        out.println("height : "+session.getAttribute("height")+"<br/>");
        out.println("weight : "+session.getAttribute("weight")+"<br/>");
        out.println("bmi : "+session.getAttribute("bmi"));

    }

}

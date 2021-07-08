package com.web.controller;

import com.web.job.LongJob;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//asyncSupported = true非同步

@WebServlet(urlPatterns = "/controller/longjob", asyncSupported = true)
public class LongJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //文件格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("進入servlet時間:" + new Date() + "<p / >");
        //將資料丟給前端
        out.flush();

        //LongJob
        //AsyncContext 請求非同步的環境資訊
        AsyncContext ctx = req.startAsync();
        LongJob longJob = new LongJob(ctx);
        Thread t = new Thread(longJob);
        t.start();
        out.print("離開servlet時間:" + new Date() + "<p / >");

    }

}

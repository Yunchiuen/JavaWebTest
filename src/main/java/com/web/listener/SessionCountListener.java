package com.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCountListener implements HttpSessionListener {

    //創健
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //先取得全域變數
        ServletContext application = se.getSession().getServletContext();
        //有沒有count這個全域變數
        if (application.getAttribute("count") == null) {
            //如果沒有就先設一個預設值0
            application.setAttribute("count", 0);
        }
        //取得裡面的內容++
        int count = Integer.parseInt(application.getAttribute("count").toString());
        count++;
        application.setAttribute("count", count);
        System.out.println("sessionCreated: " + count);
    }

    //銷毀
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //先取得全域變數
        ServletContext application = se.getSession().getServletContext();
        //有沒有count這個全域變數
        if (application.getAttribute("count") == null) {
            return;
        }
        //取得裡面的內容++
        int count = Integer.parseInt(application.getAttribute("count").toString());
        count--;
        application.setAttribute("count", count);
        System.out.println("sessionDestroyed: " + count);
    }

}

package com.web.controller;

import com.web.service.CalcAreaService;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet()裡面只有一個字串就代表urlPatterns

@WebServlet("/controller/CalcArea")
public class CalcAreaServlet extends HttpServlet {

    //http://localhost:8080/JavaWebTest/controller/CalcArea
    //405錯誤 這個Servlet沒有寫doGet無法對這方法進行GET請求
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().print("SORRY");
//    }
    //計算service
    private CalcAreaService service = new CalcAreaService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收參數
        String string_type = req.getParameter("type");
        String string_r = req.getParameter("r");
        int type = Integer.parseInt(string_type);
        int r = Integer.parseInt(string_r);

        //2.邏輯運算
        double area = service.getResult(type, r);
        String typeName = service.getNameByType(type);
        //3.建立分派器與jsp位置
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/calcAreaResult.jsp");
        //3.1新增/設定resqest屬性,傳遞給jsp頁面使用
        req.setAttribute("r", r);
        req.setAttribute("result", String.format("%.2f", area));
        req.setAttribute("typeName", typeName);
        //3.2傳送
        rd.forward(req, resp);
        //resp.getWriter().print(String.format("r: %d,area: %.2f", r,area));
    }

}

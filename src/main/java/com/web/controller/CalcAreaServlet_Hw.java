package com.web.controller;

import com.web.service.CalcAreaService;
import com.web.service.CalcAreaService_Hw;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet()裡面只有一個字串就代表urlPatterns

@WebServlet("/controller/CalcArea_Hw")
public class CalcAreaServlet_Hw extends HttpServlet {

    //http://localhost:8080/JavaWebTest/controller/CalcArea
    //405錯誤 這個Servlet沒有寫doGet無法對這方法進行GET請求
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().print("SORRY");
//    }
    //計算service
    private CalcAreaService_Hw service = new CalcAreaService_Hw();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.接收多組參數(多重複名稱 type=1&r=10&type=2&r=20&type=1&r=30)
        String[] string_types= req.getParameterValues("type");
        String[] string_rs = req.getParameterValues("r");
        
        //2.邏輯運算
        List<Map> list=service.getAreaResults(string_types, string_rs);
        
        //3.建立分派器與jsp位置
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/calcAreaResult_Hw.jsp");
        //3.1新增/設定resqest屬性,傳遞給jsp頁面使用
        req.setAttribute("list", list);
        //3.2傳送
        rd.forward(req, resp);
    }

}

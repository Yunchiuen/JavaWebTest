package com.web.controller;

import com.web.service.BMIService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/BMI")
public class BMIServlet extends HttpServlet{
    private BMIService service=new BMIService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收多組參數
        String[] heights= req.getParameterValues("height");
        String[] weights= req.getParameterValues("weight");
        //2.邏輯運算
        List<Map> list=service.getBMIResults(heights, weights);
        //3.建立分派器與jsp位置
        RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/view/bmiResult.jsp");
        //3.1新增/設定resqest屬性,傳遞給jsp頁面使用
        req.setAttribute("list", list);
        //3.2傳送
        rd.forward(req, resp);
        
    }

}

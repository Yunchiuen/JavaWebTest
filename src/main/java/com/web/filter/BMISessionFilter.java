package com.web.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/controller/bmi_session")
public class BMISessionFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //驗證授權碼
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        Object authCode = session.getAttribute("authCode");
        PrintWriter out = res.getWriter();
        if (!req.getMethod().equalsIgnoreCase("get")) {
            if (code.equals(authCode)) {
                session.setAttribute("authCode", null);
                chain.doFilter(req, res); 
            } else {
                session.invalidate();
                out.println("驗證碼錯誤" + "<br />");
                out.println(code + "==" + authCode);
                
            }
        } else {
            chain.doFilter(req, res);
        }

    }

}

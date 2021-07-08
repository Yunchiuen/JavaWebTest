package com.web.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/secure/*")
public class LoginFilter extends HttpFilter {

    private static Map<String, String> map = new LinkedHashMap<>();

    static {
        map.put("john", "1234");
        map.put("Mary", "4567");
        map.put("Yun", "6666");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean check = false;
        check = map.entrySet().stream()
                .filter(s -> s.getKey().equals(username) && s.getValue().equals(password))
                .findAny()
                .isPresent();
        //findAny()有沒有符合 getKey 與 getValue
//        if (map.get(username).equals(password)) {
//            check = true;
//        }
        if (check) {
            //放行 
            chain.doFilter(req, res);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
            if (!(username == null && password == null)) {
                req.setAttribute("error", "登入失敗");
            }
            
            rd.forward(req, res);
        }

    }

}

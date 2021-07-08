package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controller/bmi_session_invalid")
public class BMISessionInvalidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        PrintWriter out = resp.getWriter();
        if (session != null) {
            out.println("session invalid session id:" + session.getId());
        }else{
            out.println("session already invalid");
        }

        session.invalidate();
    }

}

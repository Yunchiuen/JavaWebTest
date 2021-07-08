package com.web.filter;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
//Response的外包類別 HttpServletResponseWrapper

public class MyResponse extends HttpServletResponseWrapper {

    private PrintWriter out;
    private CharArrayWriter bufferedWriter;

    public MyResponse(HttpServletResponse response) {
        super(response);
        bufferedWriter = new CharArrayWriter();
        out = new PrintWriter(bufferedWriter);
    }

    public String getHTMLString() {
        return bufferedWriter.toString();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return out;
    }

}

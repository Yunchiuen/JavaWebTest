package com.web.job;

import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;

public class LongJob implements Runnable {

    private AsyncContext ctx;

    public LongJob(AsyncContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run() {
        try {
            //得到當時請求連線的Response
            PrintWriter out = ctx.getResponse().getWriter();
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000);
                out.println(i + " 很長的工作做完了" + new Date() + "<p / >");
                out.flush();
            }
            ctx.complete();//做完了
        } catch (Exception e) {
        }

    }

}
